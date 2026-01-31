package com.example.smart_campus_companion.ui.screens

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun LoginScreen(
    onLoginClick: () -> Unit
) {

    Button(onClick = onLoginClick) {
        Text("This is login screen ")
        Text("Go to Dashboard")
    }

}
