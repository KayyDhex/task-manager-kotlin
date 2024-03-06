package com.example.tasksmanager.presentation.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.tasksmanager.data.TaskRepository
import com.example.tasksmanager.data.database.CustomDatabase
import com.example.tasksmanager.presentation.viewModels.HomeViewModel
import com.example.tasksmanager.presentation.viewModels.LoginViewModel
import com.example.tasksmanager.presentation.viewModels.NewTaskViewModel
import com.example.tasksmanager.presentation.viewModels.TaskDetailViewModel
import com.example.tasksmanager.presentation.views.HomeScreen
import com.example.tasksmanager.presentation.views.LoginScreen
import com.example.tasksmanager.presentation.views.NewTaskScreen
import com.example.tasksmanager.presentation.views.ProfileScreen
import com.example.tasksmanager.presentation.views.TaskDetail
import java.lang.Integer.parseInt


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Navigator(database: CustomDatabase) {

    var navController = rememberNavController()
    val daoTask = database.taskDao()

    var taskRepository  = TaskRepository(daoTask)
    var loginViewModel = LoginViewModel()
    var newTaskViewModel = NewTaskViewModel(daoTask)
    var homeViewModel = HomeViewModel(daoTask, taskRepository)
    var taskDetailViewModel = TaskDetailViewModel(taskRepository)

    NavHost(navController, startDestination = "Login" ){
        composable("Login"){
            LoginScreen(navController, loginViewModel)
        }
        composable("Home"){
            HomeScreen(navController, homeViewModel)
        }
        composable("NewTask"){
            NewTaskScreen(navController,newTaskViewModel)
        }
        composable("Profile"){
            ProfileScreen(navController)
        }
        composable("TaskDetail/{taskId}", arguments = listOf(
            navArgument("taskId"){type= NavType.StringType}
        )){ backStackEntry ->  
            val id = backStackEntry.arguments?.getString("taskId")
            requireNotNull(id, {"No es posible indexar un null"})
            taskDetailViewModel.getById(parseInt(id))
            TaskDetail(navController, taskDetailViewModel)
        }
    }
}