package com.example.demobatchjob;

class Person {
    private var lastName: String? = null
    private var firstName: String? = null

    constructor(firstName: String?, lastName: String?) {
        this.firstName = firstName
        this.lastName = lastName
    }

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