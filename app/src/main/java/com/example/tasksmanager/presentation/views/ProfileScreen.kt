package com.example.tasksmanager.presentation.views

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.tasksmanager.presentation.components.CustomBottomAppBar

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ProfileScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Perfil")
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                )
            )
        },
        bottomBar = {
            CustomBottomAppBar(navController)
        }
    ) {
        Column {
            Text("Profile")
        }
    }
}