package user

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

        try{
            vCode.save(flush: true, failOnError: true)
            response.put('result', vCode)

            return  response
        }catch(ValidationException e){
            e.printStackTrace()
            return vCode.errors
        }

    }
}
