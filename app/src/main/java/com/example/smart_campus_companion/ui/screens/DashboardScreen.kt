package com.example.smart_campus_companion.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun DashboardScreen(
    onOpenCampusInfo: () -> Unit,
    onLogout: () -> Unit
) {

    Column {
        Button(onClick = onOpenCampusInfo) {
            Text("This is Dashboard screen ")
            Text("Open Campus Info")
        }

        Button(onClick = onLogout) {
            Text("Back to Login")
        }
    }
}
