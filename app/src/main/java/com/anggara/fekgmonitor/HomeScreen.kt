package com.anggara.fekgmonitor

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.anggara.fekgmonitor.ui.theme.FEKGMonitorTheme

@Composable
fun HomeScreen(
    navController: NavController
    ){
    MaterialTheme{
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(text = "FEKG Monitor")
                    },
                    navigationIcon = {
                        IconButton(onClick = {/* doSomething() */ }) {
                            Icon(Icons.Default.Menu, contentDescription = null)
                        }
                    },
                    actions = {
                        IconButton(onClick = {
                            navController.navigate(route = FekgScreen.History.route)
                        }) {
                            Icon(Icons.Default.History, contentDescription = null)
                        }
                    }
                )
            }
        ) {innerPadding ->
            HomeBodyContent(Modifier.padding(innerPadding))
        }
    }
//    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
}

@Composable
fun HomeBodyContent(modifier: Modifier = Modifier) {
    Column(modifier = modifier
        .padding(8.dp)
        .fillMaxSize()) {
        Text(text = "Welcome!",
            style = MaterialTheme.typography.h3
        )
        Text(text = "Press start button to start",
            style = MaterialTheme.typography.subtitle1)
        GraphCard()
        Button(
            onClick = { /*TODO*/ },
            modifier = modifier.align(Alignment.CenterHorizontally)) {
            Text(text = "Start")
        }
    }
}

@Composable
fun GraphCard(){
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)
    ) {
        Row(modifier = Modifier
                .fillMaxWidth()
        ) {
            Column(modifier = Modifier
                .padding(8.dp)
                .weight(1f)
            ) {
                Text(text = "MHR",
                    style = MaterialTheme.typography.body1
                )
                Text(text = "98 bpm",
                    style = MaterialTheme.typography.h4
                )
            }
            Column(modifier = Modifier
                .padding(8.dp)
            ) {
                Text(text = "FHR",
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier.align(Alignment.End)
                )
                Text(text = "124 bpm",
                    style = MaterialTheme.typography.h4,
                    modifier = Modifier.align(Alignment.End)
                )
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FEKGMonitorTheme {
        HomeScreen(navController = rememberNavController())
    }
}