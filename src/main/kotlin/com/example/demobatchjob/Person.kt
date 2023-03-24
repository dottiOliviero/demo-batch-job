package com.example.demobatchjob;

class Person(private var firstName: String?, private var lastName: String?) {

    // needed for spring magic
    constructor(): this(null, null)

    fun setFirstName(firstName: String?) {
        this.firstName = firstName
    }

    fun getFirstName(): String? {
        return firstName
    }

    fun getLastName(): String? {
        return lastName
    }

    fun setLastName(lastName: String?) {
        this.lastName = lastName
    }

    override fun toString(): String {
        return "firstName: $firstName, lastName: $lastName"
    }

}
