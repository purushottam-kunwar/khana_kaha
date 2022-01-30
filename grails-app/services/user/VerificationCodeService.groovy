package user

import enumconstants.Status
import grails.converters.JSON
import grails.gorm.transactions.Transactional
import grails.validation.ValidationException
import org.grails.web.json.JSONObject

@Transactional
class VerificationCodeService {

    def create(params) {
        JSONObject response = new JSONObject()

        def vCode = new VerificationCode()
        vCode.code = params?.code
        vCode.email = params?.email

        try {
            vCode.save(flush: true, failOnError: true)
            response.put('result', vCode)

            return response
        } catch (ValidationException e) {
            e.printStackTrace()
            return vCode.errors
        }
    }

    def verify(params) {
        JSONObject response = new JSONObject()

        def email = params?.email
        def code = params?.code

        def vCode = VerificationCode.findByEmailAndCodeAndStatus(email, code, Status.ACTIVE)
        if (vCode) {
            vCode.status = Status.EXPIRED
            vCode.updatedAt = new Date()

            try {
                vCode.save(flush: true, failOnError: true)
                response.put('result', response)

                return response
            } catch (ValidationException e) {
                e.printStackTrace()
                return vCode.errors
            }
        } else {
            return null
        }
    }
}
