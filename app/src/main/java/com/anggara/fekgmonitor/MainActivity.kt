package com.anggara.fekgmonitor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.anggara.fekgmonitor.ui.theme.FEKGMonitorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FEKGMonitorTheme {
                // A surface container using the 'background' color from the theme
                Myapp()
            }
        }
    }
}

@Composable
fun Myapp(){
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "FEKG Monitor")
                },
                navigationIcon = {
                    IconButton(onClick = { /* doSomething() */ }) {
                        Icon(Icons.Default.Menu, contentDescription = null)
                    }
                },
                actions = {
                    IconButton(onClick = { /* doSomething() */ }) {
                        Icon(Icons.Default.History, contentDescription = null)
                    }
                }
            )
        }
    ) {innerPadding ->
        BodyContent(Modifier.padding(innerPadding))
    }
//    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
    }

@Composable
fun BodyContent(modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(8.dp)) {
        Text(text = "Welcome!")
        Text(text = "Press start button to start")
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Start")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FEKGMonitorTheme {
        Myapp()
    }
}