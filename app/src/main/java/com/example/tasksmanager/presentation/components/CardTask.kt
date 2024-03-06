package com.example.tasksmanager.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.tasksmanager.domain.entities.Task

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardTask(task: Task, navController:NavController){
    Card (
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        onClick = {
            navController.navigate("TaskDetail/${task.id}")
        }
    ){
        Column (
            modifier = Modifier.padding(vertical = 7.dp, horizontal = 10.dp)
        ){
            Text(text = "Tarea ${task.id}")
            Text(text = task.name)
            Text(text = task.description)
        }
    }
}