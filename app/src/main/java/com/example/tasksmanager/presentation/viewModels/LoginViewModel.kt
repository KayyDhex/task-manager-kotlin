package com.example.tasksmanager.presentation.viewModels

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tasksmanager.data.database.UserDatabaseDao
import kotlinx.coroutines.launch

class LoginViewModel() : ViewModel(){
    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password

    private val _isEnabled = MutableLiveData<Boolean>()
    val isEnabled: LiveData<Boolean> = _isEnabled

    fun onChange(email: String, password: String) {
        _email.value = email
        _password.value = password
        _isEnabled.value = isValidEmail(email) && isValidPassword(password)
    }

     fun check(){
        viewModelScope.launch {

        }
    }

    private fun isValidEmail(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
    private fun isValidPassword(password: String): Boolean {
        return password.length >= 8
    }


}