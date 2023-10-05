package com.example.mynutri_app.model

class Validation {
    companion object {
        fun isValidEmail(email: String): Boolean {
            val regexPattern = Regex("^\\w+([.-]?\\w+)*@\\w+([.-]?\\w+)*(\\.\\w{2,4})+\$");
            return regexPattern.matches(email);
        }

        fun isValidPassword(password: String): Boolean {
            return password.length >= 8;
        }
    }
}