package com.anggara.fekgmonitor

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Devices
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector

enum class FEKGScreen(
    val icon: ImageVector
) {
    Home(
        icon = Icons.Default.Home
    ),
    History(
        icon = Icons.Default.History
    ),
    Devices(
        icon = Icons.Default.Devices
    );

    companion object {
        fun fromRoute(route: String?): FEKGScreen =
            when (route?.substringBefore("/")) {
                Home.name -> Home
                History.name -> History
                Devices.name -> Devices
                null -> Home
                else -> throw IllegalArgumentException("Route $route is not recognized.")
            }
    }
}