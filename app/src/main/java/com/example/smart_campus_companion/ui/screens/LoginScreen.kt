package com.example.smart_campus_companion.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.smart_campus_companion.data.SessionManager
import com.example.smart_campus_companion.domain.AuthLogic
import com.example.smart_campus_companion.domain.LoginState
import com.example.smart_campus_companion.ui.theme.PrimaryBlue

@Composable
fun LoginScreen(navController: NavController) {
    var studentId by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var loginState by remember { mutableStateOf<LoginState>(LoginState.Idle) }
    val context = LocalContext.current
    val sessionManager = SessionManager(context)

    LaunchedEffect(loginState) {
        when (val state = loginState) {
            is LoginState.Success -> {
                sessionManager.setLoggedIn(true)
                navController.navigate("dashboard")
            }
            else -> Unit
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(PrimaryBlue, Color(0xFF1565C0))
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 60.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = Icons.Default.School,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(80.dp)
            )
            Text(
                text = "Smart Campus",
                color = Color.White,
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold
            )
        }

        Card(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .fillMaxHeight(0.7f),
            shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column(
                modifier = Modifier
                    .padding(32.dp)
                    .fillMaxSize()
            ) {
                Text(
                    text = "Welcome Back",
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF1D2939)
                )
                Text(
                    text = "Sign in to your student portal",
                    color = Color.Gray
                )

                Spacer(modifier = Modifier.height(32.dp))

                OutlinedTextField(
                    value = studentId,
                    onValueChange = { studentId = it },
                    label = { Text("Student ID Number") },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    singleLine = true,
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = PrimaryBlue,
                        unfocusedBorderColor = Color.LightGray
                    )
                )

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text("Password") },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    trailingIcon = {
                        val image = if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff
                        IconButton(onClick = { passwordVisible = !passwordVisible }) {
                            Icon(imageVector = image, contentDescription = null)
                        }
                    },
                    singleLine = true,
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = PrimaryBlue,
                        unfocusedBorderColor = Color.LightGray
                    )
                )

                if (loginState is LoginState.Error) {
                    Text(
                        text = (loginState as LoginState.Error).message,
                        color = Color.Red,
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }

                Spacer(modifier = Modifier.height(32.dp))

                Button(
                    onClick = {
                        loginState = LoginState.Loading
                        if (AuthLogic.authenticate(studentId, password)) {
                            loginState = LoginState.Success(studentId)
                        } else {
                            loginState = LoginState.Error("Invalid ID or Password")
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = PrimaryBlue),
                    enabled = loginState !is LoginState.Loading
                ) {
                    if (loginState is LoginState.Loading) {
                        CircularProgressIndicator(color = Color.White)
                    } else {
                        Text("Enter Portal", fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
                    }
                }

                Spacer(modifier = Modifier.weight(1f))

                Text(
                    text = "Smart Campus Companion v1.0",
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    style = MaterialTheme.typography.labelSmall,
                    color = Color.LightGray
                )
            }
        }
    }
}