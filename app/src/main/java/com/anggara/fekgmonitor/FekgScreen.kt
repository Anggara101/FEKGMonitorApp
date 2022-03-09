package com.anggara.fekgmonitor

sealed class FekgScreen(val route: String) {
    object Home: FekgScreen(route = "home_screen")
    object History: FekgScreen(route = "history_screen")
}