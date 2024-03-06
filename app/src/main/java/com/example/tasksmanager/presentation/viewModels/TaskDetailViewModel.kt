package com.example.tasksmanager.presentation.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tasksmanager.data.TaskRepository
import com.example.tasksmanager.data.database.TaskDatabaseDao
import com.example.tasksmanager.domain.entities.Task
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class TaskDetailViewModel(
    private val repository: TaskRepository
) : ViewModel(){

    private val _task = MutableLiveData<Task>()
    val task: LiveData<Task> = _task

    fun getById(id:Int) = viewModelScope.launch {
        _task.value = repository.getById(id)
    }
}