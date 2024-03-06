package com.example.tasksmanager.presentation.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tasksmanager.data.TaskRepository
import com.example.tasksmanager.data.TaskState
import com.example.tasksmanager.data.database.TaskDatabaseDao
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class HomeViewModel(
    private val dao: TaskDatabaseDao,
    private val repository: TaskRepository,
) : ViewModel() {

    var state by mutableStateOf(TaskState())
        private set

    private val _message = MutableLiveData<String>()
    val message: LiveData<String> = _message

    init {
        viewModelScope.launch {
            dao.getTasks().collectLatest {
                state = state.copy(
                    taskList = it
                )
            }
//            _message.value = repository.getMessage()
        }
    }
}