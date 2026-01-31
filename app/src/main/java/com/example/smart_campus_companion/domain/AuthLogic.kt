package com.example.smart_campus_companion.domain

object AuthLogic {
    fun authenticate(user: String, pass: String): Boolean {
        return user == "admin" && pass == "1234"
    }
}