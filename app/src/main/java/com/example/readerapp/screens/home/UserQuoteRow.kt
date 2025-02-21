package com.example.readerapp.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun UserQuoteRow(){
    val TEXT_QUOTE = "Your reading activity right now..."
    //val user = FirebaseAuth.getInstance().currentUser
    Row(modifier = Modifier.fillMaxWidth().padding(16.dp), horizontalArrangement = Arrangement.SpaceBetween) {
        Text(text = TEXT_QUOTE, fontSize = 19.sp, modifier = Modifier.fillMaxWidth(0.5f),
            fontWeight = FontWeight.SemiBold)
        Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Bottom) {
            Icon(imageVector = Icons.Default.AccountCircle, contentDescription = "user")
            Text(text = "Tamega Canadien", fontSize = 16.sp, color = Color.Red)
        }
    }
}