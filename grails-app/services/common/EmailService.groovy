package common

import grails.gorm.transactions.Transactional
import jline.internal.Log
import utils.RandGeneratorUtils

@Transactional
class EmailService {
    def verificationCodeService

    def send(params) {
        def fullName = params?.fullName
        def email = params?.email
        def verificationCode = RandGeneratorUtils.getRanGeneratorNum(4)

        //send mail
        println "Mail Sending..."
        def body = String.join(
                System.getProperty("line.separator"),
                "Hi, ${fullName}",
                "Your Verification Code is ${verificationCode}"
        )
        sendMail {
            to email
            text body
        }
        println "Mail Send"

        // save verification code
        verificationCodeService.create(code: verificationCode, email: email)
    }
}
