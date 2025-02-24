package com.example.readerapp.viewModel

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.readerapp.model.MUser
import com.example.readerapp.states.LoadingState
import com.example.readerapp.utils.DatabaseConstants.USER_COLLECTION
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(): ViewModel(){
    //val loadingState = MutableStateFlow(LoadingState.Idle)
    private val auth: FirebaseAuth = Firebase.auth
    private val _loading = mutableStateOf(LoadingState.Idle)
    val loading : State<LoadingState> = _loading



    fun createUserWithEmailAndPassword(email: String, password: String, navigateLogin:()->Unit){
        try {
            _loading.value = LoadingState.Loading
            auth.createUserWithEmailAndPassword(email.trim(), password.trim())
                .addOnCompleteListener{
                        task->
                    if(task.isSuccessful){
                        _loading.value = LoadingState.Success
                        navigateLogin()
                    }else{
                        _loading.value = LoadingState.Failed
                    }
                }
        } catch (e: Exception) {
            _loading.value = LoadingState.Failed
        }
    }

    fun signInWithEmailAndPassword(email: String, password: String, navigateHome:()->Unit) = viewModelScope.launch {
        try {
            _loading.value = LoadingState.Loading
            auth.signInWithEmailAndPassword(email.trim(), password.trim())
                .addOnCompleteListener{
                    task->
                    if(task.isSuccessful){
                        _loading.value = LoadingState.Success
                        Log.d("FirebaseAuth", "Login successful: $email ${_loading.value}")
                        createUser(task.result.user)
                        navigateHome()
                    }else{
                        _loading.value = LoadingState.Failed
                        Log.d("FirebaseAuth", "Login failed")
                    }
                }
        } catch (e: Exception) {
            _loading.value = LoadingState.Failed
            Log.e("FirebaseAuth", "Error: ${e.message}")
        }
    }

    private fun createUser(user:FirebaseUser?){
        val userId = user?.uid
        val displayName = user?.email?.split('@')?.get(0)
        val userToPersist = MUser(userId= userId.toString(), displayName = displayName.toString(),
            email = user?.email.toString(), avatarUrl = "", quote = "", profession = "", id = null).toMap()
        FirebaseFirestore.getInstance().collection(USER_COLLECTION).add(userToPersist)
    }


}