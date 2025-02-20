package com.example.readerapp.screens.signup

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.readerapp.components.ReaderLogo
import com.example.readerapp.navigation.ReaderScreens

@Composable
fun SignupScreen(navController: NavController?){
    val  email = rememberSaveable { mutableStateOf("") }
    val  password = rememberSaveable { mutableStateOf("") }

    Scaffold { innerPadding ->
        Column(Modifier.padding(innerPadding).fillMaxSize()) {
            Column(horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize().padding(top=40.dp)) {
                ReaderLogo()
                Text(text = "Create new Account", fontSize = 20.sp,)
                Column(modifier = Modifier.padding(16.dp).fillMaxWidth()) {
                    SignUpForm(email, password)
                    Spacer(modifier = Modifier.padding(10.dp))

                    Row(modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center) {
                        Text(text = "Already having account?",
                            fontSize = 13.sp)
                        Text(text = "Login",
                            fontSize = 13.sp,
                            color = Color.Blue,
                            textDecoration = TextDecoration.Underline,
                            modifier = Modifier.clickable {
                                navController?.navigate(route = ReaderScreens.LOGIN_SCREEN.path)
                            })
                    }
                }
            }
        }
    }
}