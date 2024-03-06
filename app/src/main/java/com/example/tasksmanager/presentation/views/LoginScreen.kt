package com.example.tasksmanager.presentation.views

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.tasksmanager.presentation.viewModels.LoginViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LoginScreen(navController: NavHostController, loginViewModel: LoginViewModel) {

    val email : String by loginViewModel.email.observeAsState("")
    val password : String by loginViewModel.password.observeAsState("")
    val isEnabled : Boolean by loginViewModel.isEnabled.observeAsState(false)

    Scaffold {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Bienvenido a Task Manager" )
            Button(
                onClick = { navController.navigate("Home") }
            ) {
                Text(text = "Entrar")
            }
        }
    }
}