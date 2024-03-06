package com.example.tasksmanager.presentation.views

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.tasksmanager.presentation.components.CardTask
import com.example.tasksmanager.presentation.components.CustomBottomAppBar
import com.example.tasksmanager.presentation.viewModels.HomeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavHostController, homeViewModel: HomeViewModel) {

    val message : String by homeViewModel.message.observeAsState("")

    Scaffold(
        bottomBar = {
            CustomBottomAppBar(navController)
        },
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Inicio")
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                )
            )
        },
        ) {innerPadding->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
        ) {
            Text("$message")
            homeViewModel.state.taskList.forEach{
                task ->
                CardTask(task, navController)
            }
        }
    }
}