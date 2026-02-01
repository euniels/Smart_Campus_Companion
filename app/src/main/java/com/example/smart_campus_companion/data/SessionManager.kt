package com.example.smart_campus_companion.data

import android.content.Context

class SessionManager(context: Context) {

    private val prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

    fun setLoggedIn(isLoggedIn: Boolean) {
        prefs.edit()
            .putBoolean(KEY_LOGGED_IN, isLoggedIn)
            .apply()
    }

    fun isLoggedIn(): Boolean {
        return prefs.getBoolean(KEY_LOGGED_IN, false)
    }

    fun clearSession() {
        prefs.edit().clear().apply()
    }

    companion object {
        private const val PREF_NAME = "smart_campus_session"
        private const val KEY_LOGGED_IN = "is_logged_in"
    }
}
