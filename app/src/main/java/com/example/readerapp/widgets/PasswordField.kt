package com.example.readerapp.widgets

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.example.readerapp.R

@Composable
fun PasswordField(
    label: String,
    valueState: MutableState<String>,
    onAction: KeyboardActions = KeyboardActions.Default,
    imeAction: ImeAction = ImeAction.Default,
    enabled: Boolean = true,
    isSingleLine: Boolean = true,
    modifier: Modifier = Modifier,
    passwordVisibility: MutableState<Boolean>
){
    val visualTransformation = if(passwordVisibility.value) VisualTransformation.None else
        PasswordVisualTransformation()
    OutlinedTextField(
        value = valueState.value,
        label = { Text(text = label) },
        onValueChange = { valueState.value = it },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password, imeAction = imeAction),
        modifier = modifier,
        enabled = enabled,
        keyboardActions = onAction,
        singleLine = isSingleLine,
        visualTransformation = visualTransformation,
        trailingIcon = { PasswordVisibility( passwordVisibility = passwordVisibility ) }
    )

}
@Composable
fun PasswordVisibility(passwordVisibility: MutableState<Boolean>){
    val visible = passwordVisibility.value
    IconButton(onClick = {passwordVisibility.value=!passwordVisibility.value}) {
        if(visible)
            Icon(painter = painterResource(id = R.drawable.eye_off), contentDescription = "hide")

        else
            Icon(painter = painterResource(id = R.drawable.eye), contentDescription = "show")

    }
}