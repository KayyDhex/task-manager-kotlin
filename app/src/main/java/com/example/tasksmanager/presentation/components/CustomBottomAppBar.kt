package com.example.tasksmanager.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun CustomBottomAppBar(navController: NavController){
    BottomAppBar {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { navController.navigate("Home") }) {
                Icon(Icons.Outlined.Home,"Home")
            }
            IconButton(onClick = { navController.navigate("NewTask") }) {
                Icon(Icons.Outlined.Add,"Add Taks")
            }
            IconButton(onClick = { navController.navigate("Profile") }) {
                Icon(Icons.Outlined.Person,"Profile")
            }
        }
    }
}