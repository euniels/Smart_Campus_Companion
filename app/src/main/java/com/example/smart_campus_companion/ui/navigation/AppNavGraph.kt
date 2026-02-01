package com.example.smart_campus_companion.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.smart_campus_companion.data.SessionManager
import com.example.smart_campus_companion.ui.screens.CampusInfoScreen
import com.example.smart_campus_companion.ui.screens.DashboardScreen
import com.example.smart_campus_companion.ui.screens.LoginScreen

@Composable
fun AppNavGraph() {
    val navController = rememberNavController()
    val context = LocalContext.current
    val sessionManager = remember { SessionManager(context) }
    val startDestination = if (sessionManager.isLoggedIn()) Routes.Dashboard.route else Routes.Login.route

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(Routes.Login.route) {
            LoginScreen(navController = navController)
        }

        composable(Routes.Dashboard.route) {
            DashboardScreen(navController = navController)
        }

        composable(Routes.CampusInfo.route) {
            CampusInfoScreen(navController = navController)
        }
    }
}
