package user

import enumconstants.Status

class User {
    String fullName
    String phoneNumber
    String email
    String address
    Status status = Status.INACTIVE
    Date createdAt = new Date()
    Date updatedAt

    static constraints = {
        fullName blank: false, nullable: false
        phoneNumber blank: false, nullable: false
        email blank: false, nullable: false, maxSize: 400, email: true, unique: true
        status blank: true, nullable: true
        address blank: true, nullable: true
        createdAt blank: true, nullable: true
        updatedAt blank: true, nullable: true
    }

    static mapping = {
        table '`user`'
    }
}
