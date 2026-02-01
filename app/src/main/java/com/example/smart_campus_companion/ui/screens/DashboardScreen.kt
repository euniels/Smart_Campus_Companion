package com.example.smart_campus_companion.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AutoGraph
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.smart_campus_companion.data.SessionManager
import com.example.smart_campus_companion.ui.theme.PrimaryBlue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(navController: NavController) {
    val context = LocalContext.current
    val sessionManager = remember { SessionManager(context) }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        "Hi, Student!", // Simplified greeting
                        fontWeight = FontWeight.Bold,
                        color = PrimaryBlue
                    )
                },
                actions = {
                    IconButton(onClick = {
                        sessionManager.clearSession()
                        navController.navigate("login") {
                            popUpTo(0)
                        }
                    }) {
                        Icon(
                            imageVector = Icons.Default.Logout,
                            contentDescription = "Logout"
                        )
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.White
                )
            )
        },
        containerColor = Color(0xFFF2F4F7) // Light gray for better contrast
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(20.dp)
        ) {
            Text(
                text = "Campus Services",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.ExtraBold,
                color = Color(0xFF1D2939) // Darker color for readability
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Clean Grid Layout for better readability
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.fillMaxSize()
            ) {
                item {
                    MenuCard(
                        title = "Campus Info",
                        icon = Icons.Default.Info,
                        onClick = { navController.navigate("campus_info") }
                    )
                }
                item { MenuCard(title = "Schedule", icon = Icons.Default.DateRange) }
                item { MenuCard(title = "Grades", icon = Icons.Default.AutoGraph) }
                item { MenuCard(title = "Library", icon = Icons.Default.MenuBook) }
            }
        }
    }
}

@Composable
fun MenuCard(
    title: String,
    icon: ImageVector,
    onClick: () -> Unit = {}
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f)
            .clickable { onClick() },
        shape = RoundedCornerShape(20.dp),
        color = Color.White,
        shadowElevation = 4.dp
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // High contrast icon
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = PrimaryBlue,
                modifier = Modifier.size(36.dp)
            )

            Spacer(modifier = Modifier.height(12.dp))

            // High contrast text
            Text(
                text = title,
                style = MaterialTheme.typography.labelLarge,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF344054), // Darker gray for maximum readability
                fontSize = 15.sp
            )
        }
    }
}