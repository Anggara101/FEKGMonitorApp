package com.anggara.fekgmonitor

sealed class Screen(val route: String) {
    object Home: Screen(route = "home_screen")
    object History: Screen(route = "history_screen")
}