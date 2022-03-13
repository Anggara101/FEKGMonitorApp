package com.anggara.fekgmonitor.ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.anggara.fekgmonitor.MainViewModel

@Composable
fun HomeBody(mainViewModel: MainViewModel = viewModel()) {
    Column(modifier = Modifier
        .padding(8.dp)
        .fillMaxSize()) {
        HomeText(mainViewModel)
        HomeCard()
        Button(
            onClick = { mainViewModel.onButtonStartClick() },
            modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Text(text = "Start")
        }
    }
}

@Composable
fun HomeText(mainViewModel: MainViewModel = viewModel()) {
    val homeSubtitle:String by mainViewModel.homeSubTitle.observeAsState(initial = "Press start button to start")
    Text(text = "Welcome!",
        style = MaterialTheme.typography.h4
    )
    Text(text = homeSubtitle,
        style = MaterialTheme.typography.subtitle1)
}


@Composable
fun HomeCard(){
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