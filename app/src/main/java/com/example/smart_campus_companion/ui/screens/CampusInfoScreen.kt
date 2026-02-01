package com.example.smart_campus_companion.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Business
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CampusInfoScreen(navController: NavController) {
    // Static data representing university departments
    val departments = listOf(
        "College of Computer Studies" to "ccs@university.edu.ph",
        "College of Engineering" to "coe@university.edu.ph",
        "College of Business" to "cba@university.edu.ph",
        "College of Arts and Sciences" to "cas@university.edu.ph"
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Campus Information") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            item {
                Text(
                    text = "University Departments",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(8.dp))
            }

            items(departments) { (name, email) ->
                DepartmentCard(name, email)
            }

            item {
                Spacer(modifier = Modifier.height(24.dp))
                ContactSection()
            }
        }
    }
}

@Composable
fun DepartmentCard(name: String, email: String) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        ListItem(
            headlineContent = { Text(name, fontWeight = FontWeight.SemiBold) },
            supportingContent = { Text(email) },
            leadingContent = { Icon(Icons.Default.Business, contentDescription = null, tint = MaterialTheme.colorScheme.primary) }
        )
    }
}

@Composable
fun ContactSection() {
    Column {
        Text("General Contact Information", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(8.dp))
        Row {
            Icon(Icons.Default.Phone, contentDescription = null, modifier = Modifier.size(20.dp), tint = Color.Gray)
            Spacer(modifier = Modifier.width(8.dp))
            Text("(049) 123-4567", color = Color.Gray)
        }
        Spacer(modifier = Modifier.height(4.dp))
        Row {
            Icon(Icons.Default.Email, contentDescription = null, modifier = Modifier.size(20.dp), tint = Color.Gray)
            Spacer(modifier = Modifier.width(8.dp))
            Text("info@university.edu.ph", color = Color.Gray)
        }
    }
}