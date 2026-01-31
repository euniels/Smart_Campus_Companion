package com.example.smart_campus_companion.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.smart_campus_companion.ui.screens.LoginScreen
import com.example.smart_campus_companion.ui.screens.DashboardScreen
import com.example.smart_campus_companion.ui.screens.CampusInfoScreen

@Composable
fun AppNavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.Login.route
    ) {
        composable(Routes.Login.route) {
            LoginScreen(onLoginClick = {
                navController.navigate(Routes.Dashboard.route)
            })
        }

        composable(Routes.Dashboard.route) {
            DashboardScreen(
                onOpenCampusInfo = {
                    navController.navigate(Routes.CampusInfo.route)
                },
                onLogout = {
                    navController.navigate(Routes.Login.route) {
                        popUpTo(Routes.Dashboard.route) { inclusive = true }
                    }
                }
            )
        }

        composable(Routes.CampusInfo.route) {
            CampusInfoScreen(onBack = {
                navController.popBackStack()
            })
        }
    }
}
