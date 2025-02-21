package com.example.readerapp.screens.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.Button
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
import com.example.readerapp.widgets.InputField
import com.example.readerapp.widgets.PasswordField

@Composable
fun LoginForm(
    email: MutableState<String>,
    password: MutableState<String>,
    onDone: ()->Unit
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
                onDone()
                keyboardController?.hide()
            }
        )
        Button(
            onClick = {
                onDone()
            }, modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            enabled = valid
        ) { Text(text = "Login") }
    }


}