package com.example.readerapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.readerapp.navigation.ReaderNavigation
import com.example.readerapp.ui.theme.ReaderAppTheme
import com.google.firebase.firestore.FirebaseFirestore
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ReaderAppTheme {
                val db = FirebaseFirestore.getInstance()
                val user: MutableMap<String, Any> = HashMap()
                user["firstName"] = "Tamega"
                user["lastName"] = "Canadien"

                /*db.collection("users")
                    .add(user)
                    .addOnSuccessListener {
                        Log.d("FB", "onCreate: ${it.id}")
                    }.addOnFailureListener{
                        Log.d("FB", "onCreate: $it")
                    }*/
                /*Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }*/
                ReaderNavigation()
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ReaderAppTheme {
        Greeting("Android")
    }
}