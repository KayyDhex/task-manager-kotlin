package com.example.tasksmanager.data

import androidx.lifecycle.viewModelScope
import com.example.tasksmanager.data.database.TaskDatabaseDao
import com.example.tasksmanager.data.https.RetrofitServiceFactory
import com.example.tasksmanager.domain.entities.Content
import com.example.tasksmanager.domain.entities.Part
import com.example.tasksmanager.domain.entities.RetrofitRequest
import com.example.tasksmanager.domain.entities.Task
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch

class TaskRepository(
    private val dao: TaskDatabaseDao
) {

    val service = RetrofitServiceFactory.makeRetrofitService()

    suspend fun getById(id: Int): Task {
        return dao.getTaskById(id).first()
    }

    suspend fun getAllTasks():List<Task>{
        return dao.getTasks().first()
    }

//    suspend fun getMessage():String{
//        val body = RetrofitRequest(listOf(Content(listOf(Part("Soy Hans Camilo Correa, dame un saludo corto para poner en el encabezado de mi aplicacion movil de gestion de tareas para motivarme en realizarlas")),"")))
//        service.getMessage(body)
//        return body.contents[0].parts[0].text
//    }
}