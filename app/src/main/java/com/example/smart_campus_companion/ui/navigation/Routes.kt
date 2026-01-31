package com.example.smart_campus_companion.ui.navigation

sealed class Routes(val route: String) {

    object Login : Routes("login")
    object Dashboard : Routes("dashboard")
    object CampusInfo : Routes("campus_info")

}
