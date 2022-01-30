package user

import enumconstants.Status
import grails.converters.JSON
import grails.gorm.transactions.Transactional
import grails.validation.ValidationException
import org.grails.web.json.JSONObject

@Transactional
class UserService {
    def emailService
    def verificationCodeService

    def create(params) {
        JSONObject response = new JSONObject()

        def user = User.findByEmail(params?.email)
        if (!user) {
            def newUser = new User()
            newUser.fullName = params?.fullName
            newUser.phoneNumber = params?.phoneNumber
            newUser.email = params?.email
            newUser.address = params?.address

            try {
                newUser.save(flush: true, failOnError: true)
                response.put('result', newUser)
                response.put('message', 'User Created Successfully.')

                emailService.send(fullName: newUser.fullName, email: newUser.email)

                return response
            } catch (ValidationException e) {
                e.printStackTrace()
                return newUser.errors
            }
        } else {
            response.put('message', 'User already exists.')

            return response
        }

    }

    def verify(params) {
        JSONObject response = new JSONObject()

        def email = params?.email
        def code = params?.code

        def user = User.findByEmailAndStatus(email, Status.INACTIVE)
        if (user) {
            user.status = Status.ACTIVE
            user.updatedAt = new Date()

            try {
                def vCodeRes = verificationCodeService.verify(email: user.email, code: code)
                println "vCodeRes = $vCodeRes"
                if (!vCodeRes) {
                    println "inside condition"
                    user.save(flush: true, failOnError: true)
                    response.put('result', user)
                    response.put('message', 'User Verified Successfully.')


                    return response as JSON
                } else {
                    println "outside condition"
                    def error = [:]
                    error.put("message", "Verification code not found")
                    response.put("text", (error as JSON).toString())
                    response.put("status", 404)

                    return response
                }
            } catch (ValidationException e) {
                e.printStackTrace()
                return user.errors
            }
        } else {
            def error = [:]
            error.put("message", "User not found")
            response.put("text", (error as JSON).toString())
            response.put("status", 404)

            return response
        }

    }
}
