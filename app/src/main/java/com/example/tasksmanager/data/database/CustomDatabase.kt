package com.example.tasksmanager.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.tasksmanager.domain.entities.Task
import com.example.tasksmanager.domain.entities.User
import com.example.tasksmanager.utils.DateConverter

@Database(
    entities = [Task::class],
    version = 1,
    exportSchema = false
)

@TypeConverters(DateConverter::class)

abstract class CustomDatabase: RoomDatabase() {
    abstract fun taskDao(): TaskDatabaseDao
}