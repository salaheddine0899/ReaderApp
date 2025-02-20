package com.example.readerapp.viewModel

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.readerapp.states.LoadingState
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(): ViewModel(){
    //val loadingState = MutableStateFlow(LoadingState.Idle)
    private val auth: FirebaseAuth = Firebase.auth
    private val _loading = mutableStateOf(LoadingState.Idle)
    val loading : State<LoadingState> = _loading



    fun createUserWithEmailAndPassword(){

    }

    fun signInWithEmailAndPassword(email: String, password: String) = viewModelScope.launch {
        Log.d("FirebaseAuth", "Email before trimming: '$email'")
        Log.d("FirebaseAuth", "Password before trimming: '$password'")

        val trimmedEmail = email.trim()
        val trimmedPassword = password.trim()

        Log.d("FirebaseAuth", "Email after trimming: '$trimmedEmail'")

        if (trimmedEmail.isEmpty() || trimmedPassword.isEmpty()) {
            Log.e("FirebaseAuth", "Email or password is empty")
            _loading.value = LoadingState.Failed
            return@launch
        }

        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(trimmedEmail).matches()) {
            Log.e("FirebaseAuth", "Invalid email format: '$trimmedEmail'")
            _loading.value = LoadingState.Failed
            return@launch
        }

        try {
            _loading.value = LoadingState.Loading
            val result = auth.signInWithEmailAndPassword(trimmedEmail, trimmedPassword).await()
            if (result.user != null) {
                _loading.value = LoadingState.Success
                Log.d("FirebaseAuth", "Login successful: ${result.user?.email} ${_loading.value}")
            } else {
                _loading.value = LoadingState.Failed
                Log.d("FirebaseAuth", "Login failed")
            }
        } catch (e: Exception) {
            _loading.value = LoadingState.Failed
            Log.e("FirebaseAuth", "Error: ${e.message}")
        }
    }


}