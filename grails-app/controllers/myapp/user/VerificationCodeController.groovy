package myapp.user

import static org.springframework.http.HttpStatus.NOT_FOUND

class VerificationCodeController {
    def verificationCodeService

	static responseFormats = ['json', 'xml']
    static allowedMethods = [create: "POST"]

    def create() {
        def params = request.JSON
        if (params == null) {
            render status: NOT_FOUND
            return
        }
        respond verificationCodeService.create(params)
    }

    def verify() {
        def params = request.JSON
        if (params == null) {
            render status: NOT_FOUND
            return
        }
        respond verificationCodeService.verify(params)
    }
}
