package com.anggara.fekgmonitor

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.anggara.fekgmonitor.ui.theme.FEKGMonitorTheme

@Composable
fun HistoryScreen(
    navController: NavController
){
    MaterialTheme{
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(text = "History")
                    },
                    navigationIcon = {
                        IconButton(onClick = {
                            navController.navigate(route = Screen.Home.route){
                                popUpTo(Screen.Home.route){
                                    inclusive = true
                                }
                            }
                        }) {
                            Icon(Icons.Default.ArrowBack, contentDescription = null)
                        }
                    }
                )
            }
        ) {innerPadding ->
            HistoryBodyContent(Modifier.padding(innerPadding))
        }
    }
}

@Composable
fun HistoryBodyContent(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Text(text = "History",
            style = MaterialTheme.typography.h3
            )
    }
}

@Preview(showBackground = true)
@Composable
fun HistoryPreview() {
    FEKGMonitorTheme {
        HistoryScreen(navController = rememberNavController())
    }
}