package com.example.smart_campus_companion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.smart_campus_companion.ui.navigation.AppNavGraph
import com.example.smart_campus_companion.ui.theme.Smart_Campus_CompanionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Smart_Campus_CompanionTheme {
                AppNavGraph()
            }
        }
    }
}
