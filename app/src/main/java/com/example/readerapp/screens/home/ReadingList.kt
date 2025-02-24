package com.example.readerapp.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

private val readingBooks = listOf(
    Book(
        title = "Hello Android", author = "Abdellah",
        rating = 5.0
    ),
    Book(
        title = "Camunda", author = "Tamega Cannadien",
        rating = 5.0
    ),
)
@Composable
fun ReadingList() {
    Column(modifier = Modifier.fillMaxSize()) {
        Row(modifier = Modifier.fillMaxWidth().padding(16.dp)){
            Text(text = "Reading List", style = MaterialTheme.typography.titleLarge)
        }
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)) {
            LazyRow(modifier = Modifier.fillMaxWidth()) {
                items(items = readingBooks) {
                    ReadingCard(book=it)
                    Spacer(modifier = Modifier.padding(10.dp))
                }
            }
        }
    }
}