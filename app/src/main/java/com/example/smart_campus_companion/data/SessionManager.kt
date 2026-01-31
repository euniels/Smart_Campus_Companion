package com.example.smart_campus_companion.data

import android.content.Context

class SessionManager(context: Context) {
    private val sharedPreferences = context.getSharedPreferences("campus_prefs", Context.MODE_PRIVATE)

    fun setLoginSession(isLoggedIn: Boolean) {
        sharedPreferences.edit().putBoolean("is_logged_in", isLoggedIn).apply()
    }

    fun checkSession(): Boolean {
        return sharedPreferences.getBoolean("is_logged_in", false)
    }
}