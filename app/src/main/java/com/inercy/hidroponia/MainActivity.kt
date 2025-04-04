package com.inercy.hidroponia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.inercy.hidroponia.ui.theme.HidroponiaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HidroponiaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Gilberto Alvarez",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Card(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "Hola $name!",
            modifier = modifier
        )
    }
}

@Preview
@Composable
fun HidroponiaPreview() {
    HidroponiaTheme(darkTheme = false) {
        Greeting("Android")
    }
}

@Preview
@Composable
fun HidroponiaDarkPreview() {
    HidroponiaTheme(darkTheme = true) {
        Greeting("Android")
    }
}