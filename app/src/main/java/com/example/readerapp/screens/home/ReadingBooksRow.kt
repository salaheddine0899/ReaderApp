package com.example.readerapp.screens.home

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

data class Book(
    val title: String, val author: String,
    val rating: Double
)

private val readingBooks = listOf(
    Book(
        title = "Harry potter, the half blood prince", author = "J.K Rowling",
        rating = 5.0
    ),
)

@Composable
fun ReadingBooksRow() {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)) {
        LazyRow(modifier = Modifier.fillMaxWidth()) {
            items(items = readingBooks) {
                ReadingCard(book=it)
            }
        }
    }
}