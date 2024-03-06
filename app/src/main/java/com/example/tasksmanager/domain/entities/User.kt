package com.example.tasksmanager.domain.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("users")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo("name")
    val name: String,
    @ColumnInfo("password")
    val password: String,
    @ColumnInfo("email")
    val email: String,
)
