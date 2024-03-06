package com.example.tasksmanager.data.database

import androidx.room.Dao
import androidx.room.Query
import com.example.tasksmanager.domain.entities.User
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDatabaseDao {

    @Query("SELECT * FROM users WHERE email = :email and password = :password")
    fun getUser(email:String, password:String): Flow<User?>
}