package com.example.readerapp.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController?){
    Scaffold { innerPadding->
        Column(modifier = Modifier.fillMaxSize().padding(innerPadding)) {
            HomeHeader()
            UserQuoteRow()
            ReadingBooksRow()
            ReadingList()
        }
    }
}
