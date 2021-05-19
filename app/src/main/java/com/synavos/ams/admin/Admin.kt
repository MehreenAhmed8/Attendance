package com.synavos.ams.admin

class Admin {
    fun validateAdmin(name: String, pass: String, role: String): Boolean {
        if (name == "admin" && pass == "admin" && role == "admin")
            return true
        return false
    }
}