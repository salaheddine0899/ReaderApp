package com.example.readerapp.screens.login

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.readerapp.states.LoadingState
import com.example.readerapp.viewModel.LoginViewModel
import com.example.readerapp.widgets.InputField
import com.example.readerapp.widgets.PasswordField

@Composable
fun LoginForm(
    email: MutableState<String>,
    password: MutableState<String>,
    viewModel: LoginViewModel = hiltViewModel(),
    ) {
    val passwordFocusRequest = FocusRequester.Default
    val keyboardController = LocalSoftwareKeyboardController.current
    val passwordVisibility = rememberSaveable { mutableStateOf(false) }
    val valid = remember(email.value, password.value) {
        email.value.isNotBlank() && password.value.isNotBlank()
    }
    Column(modifier = Modifier
        .padding(16.dp)
        .fillMaxWidth()) {
        InputField(
            label = "Email",
            valueState = email,
            onActions = KeyboardActions {
                passwordFocusRequest.requestFocus()
            },
            keyboardType = KeyboardType.Email,
            modifier = Modifier.fillMaxWidth(),
        )
        PasswordField(label = "Password", valueState = password,
            modifier = Modifier
                .fillMaxWidth()
                .focusRequester(passwordFocusRequest),
            passwordVisibility = passwordVisibility,
            onAction = KeyboardActions {
                if (!valid) return@KeyboardActions
                onDone(email=email.value, password= password.value)
                keyboardController?.hide()
            }
        )
        Button(
            onClick = {
                onDone(email.value, password.value)
                viewModel.signInWithEmailAndPassword(email= email.value, password = password.value)
            }, modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            enabled = valid
        ) { Text(text = "Login") }
    }
    /*LaunchedEffect(viewModel.loading) {
        Log.d("FirebaseAuth", viewModel.loading.value.toString())
    }*/
    if(viewModel.loading.value === LoadingState.Success)
        Log.d("FirebaseAuth","yes")
    else if(viewModel.loading.value === LoadingState.Failed)
        Log.d("FirebaseAuth","No")
    else if(viewModel.loading.value === LoadingState.Loading)
        CircularProgressIndicator()

}

private fun onDone(email: String, password: String) {
    Log.d("login", "$email $password")
}