package com.example.tasksmanager.data

import com.example.tasksmanager.domain.entities.Task

data class TaskState(
    val taskList: List<Task> = emptyList()
)