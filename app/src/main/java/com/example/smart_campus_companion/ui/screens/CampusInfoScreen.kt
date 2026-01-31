package com.example.smart_campus_companion.ui.screens

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun CampusInfoScreen(
    onBack: () -> Unit
) {

    Button(onClick = onBack) {
        Text("This is Campus info screen ")
        Text("Click to go back to Dashboard")
    }
}
