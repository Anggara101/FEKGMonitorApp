package com.anggara.fekgmonitor.ui.devices

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.anggara.fekgmonitor.MainViewModel

@Composable
fun DevicesBody() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Text(text = "Devices",
            style = MaterialTheme.typography.h3
        )
    }
}

@Preview
@Composable
fun DevicesPreview() {
    DevicesBody()
}