package com.example.tasksmanager.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.tasksmanager.domain.entities.Task
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDatabaseDao {
    @Query("Select * From tasks")
    fun getTasks(): Flow<List<Task>>

    @Query("Select * From tasks Where id = :id")
    fun getTaskById(id:Int): Flow<Task>

    @Insert()
    suspend fun addTask(task: Task)

    @Update()
    suspend fun updateTask(task: Task)

    @Delete()
    suspend fun deleteTask(task: Task)
}