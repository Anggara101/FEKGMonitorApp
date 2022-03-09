package com.anggara.fekgmonitor

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = FekgScreen.Home.route
        ){
        composable(
            route = FekgScreen.Home.route
        ){
            HomeScreen(navController = navController)
        }
        composable(
            route = FekgScreen.History.route
        ){
            HistoryScreen(navController = navController)
        }
    }
}