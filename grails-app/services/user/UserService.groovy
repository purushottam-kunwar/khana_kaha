package user

import grails.gorm.transactions.Transactional
import grails.validation.ValidationException
import org.grails.web.json.JSONObject

@Transactional
class UserService {

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
}
