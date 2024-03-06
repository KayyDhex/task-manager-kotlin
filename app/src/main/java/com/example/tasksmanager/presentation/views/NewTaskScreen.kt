package com.example.tasksmanager.presentation.views

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.tasksmanager.domain.entities.Task
import com.example.tasksmanager.presentation.components.CustomBottomAppBar
import com.example.tasksmanager.presentation.viewModels.NewTaskViewModel
import java.time.LocalDateTime
import java.util.Date

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun NewTaskScreen(navController: NavHostController, newTaskViewModel: NewTaskViewModel) {

    val name: String by newTaskViewModel.name.observeAsState("");
    val description: String by newTaskViewModel.description.observeAsState("")
    val category: String by newTaskViewModel.category.observeAsState("")
    val date: Date by newTaskViewModel.date.observeAsState(Date())

    var expanded by remember { mutableStateOf(false) }
    var dateShow by remember { mutableStateOf(false) }

    val context = LocalContext.current

    Scaffold(
        bottomBar = {
            CustomBottomAppBar(navController)
        },
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Nueva Tarea")
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                )
            )
        },

        ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(
                value = name, onValueChange = { value ->
                    newTaskViewModel.onChange(value, description, category, date)
                },
                placeholder = { Text("Nombre de la tarea...") },
                maxLines = 1,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            )
            TextField(
                value = description, onValueChange = { value ->
                    newTaskViewModel.onChange(name, value, category, date)
                },
                placeholder = { Text("Descripcion de la tarea...") },
                minLines = 3,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { expanded = !expanded },
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(if (category == "") "Selecciona una categoria" else category) // City name label
                    Icon(Icons.Outlined.ArrowDropDown, "Open DropDown")
                    DropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                    ) {
                        DropdownMenuItem(
                            text = { Text("Personal") },
                            onClick = {
                                newTaskViewModel.onChange(name, description, "Personal", date)
                                expanded = false
                            }
                        )
                        DropdownMenuItem(
                            text = { Text("Trabajo") },
                            onClick = {
                                newTaskViewModel.onChange(name, description, "Trabajo", date)
                                expanded = false
                            }
                        )
                        DropdownMenuItem(
                            text = { Text("Universidad") },
                            onClick = {
                                newTaskViewModel.onChange(name, description, "Universidad", date)
                                expanded = false
                            }
                        )
                    }
                }
            }
            Button(onClick = {
                newTaskViewModel.saveTask(
                    Task(name = name, description = description, category = category)
                )
                newTaskViewModel.sendNotification(context)
                newTaskViewModel.onChange("", "", "", date)

            }) {
                Text(text = "Guardar tarea")
            }
        }
    }
}