package com.example.readerapp.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

data class Book(
    val title: String, val author: String,
    val rating: Double
)

val readingBooks = listOf(
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
                Card(
                    modifier = Modifier
                        .size(260.dp)
                        .shadow(
                            elevation = 8.dp, // Apply shadow properly
                            shape = RoundedCornerShape(30.dp),
                            clip = false // Ensures the shadow is not clipped
                        ),
                    shape = RoundedCornerShape(30.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.Transparent),
                    elevation = CardDefaults.cardElevation(0.dp) // Set Card elevation to 0 to prevent extra gray effect
                ){
                    Column(modifier = Modifier.fillMaxSize().background(color = Color.Transparent).padding(4.dp)) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(150.dp),
                            verticalAlignment = Alignment.Top,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .fillMaxWidth(0.6f)
                                    .clip(shape = RectangleShape),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(text = "image")

                            }
                            Column(
                                modifier = Modifier
                                    .padding(16.dp)
                                    .width(40.dp),
                                verticalArrangement = Arrangement.Center,
                            ) {
                                Icon(
                                    imageVector = Icons.Default.FavoriteBorder,
                                    contentDescription = "fav"
                                )
                                Card(
                                    modifier = Modifier
                                        .width(35.dp)
                                        .height(70.dp),
                                    shape = CircleShape,
                                    elevation = CardDefaults.cardElevation(5.dp)
                                ) {
                                    Column(
                                        modifier = Modifier
                                            .padding(5.dp)
                                            .fillMaxSize(),
                                        verticalArrangement = Arrangement.SpaceBetween
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.Favorite,
                                            contentDescription = "fav"
                                        )
                                        Text(text = "0.0".format("%.2f"))
                                    }
                                }

                            }
                        }
                        Row(modifier = Modifier
                            .fillMaxWidth()
                            .padding(4.dp)) {
                            Text(it.title, fontWeight = FontWeight.Bold)
                        }
                        Row(modifier = Modifier
                            .fillMaxWidth()
                            .padding(4.dp)) {
                            Text(text = "[" + it.author + "]")
                        }
                    }
                }
            }
        }
    }
}