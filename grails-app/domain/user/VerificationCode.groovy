package user

import enumconstants.Status

class VerificationCode {
    String code
    Status status = Status.ACTIVE
    String email
    Date createdAt = new Date()
    Date updatedAt


    static constraints = {
        code nullable: false, blank: false
        status nullable: false, blank: false
        email nullable: false, blank: false
        createdAt nullable: true, blank: true
        updatedAt nullable: true, blank: true
    }
}
