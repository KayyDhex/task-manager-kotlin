package com.example.tasksmanager.domain.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity("tasks")
data class Task(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo("name")
    val name: String,
    @ColumnInfo("description")
    val description: String,
    @ColumnInfo("category")
    val category: String,
//    @ColumnInfo("date")
//    val date: LocalDateTime = LocalDateTime.now()
)