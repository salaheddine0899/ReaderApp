package com.example.readerapp.widgets

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun InputField(
    label: String,
    valueState: MutableState<String>,
    onActions: KeyboardActions = KeyboardActions.Default,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Default,
    enabled: Boolean = true,
    isSingleLine: Boolean = true,
    modifier: Modifier = Modifier,
){
    OutlinedTextField(
        value = valueState.value,
        label = { Text(text = label) },
        onValueChange = { valueState.value = it },
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType, imeAction = imeAction),
        modifier = modifier,
        enabled = enabled,
        keyboardActions = onActions,
        singleLine = isSingleLine,
    )

}