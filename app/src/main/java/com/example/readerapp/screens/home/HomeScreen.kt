package com.example.readerapp.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.readerapp.screens.topbars.HomeTopBar

@Composable
fun HomeScreen(navController: NavController?){
    Scaffold(
        topBar = { HomeTopBar(navController=navController) },
        floatingActionButton = {
            FabContent(){

            }
        }
    ) { innerPadding->
        Column(modifier = Modifier.fillMaxSize().padding(innerPadding)) {
            UserQuoteRow()
            ReadingBooksRow()
            ReadingList()
        }
    }
}
