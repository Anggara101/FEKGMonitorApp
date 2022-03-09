package com.anggara.fekgmonitor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.anggara.fekgmonitor.ui.theme.FEKGMonitorTheme

class MainActivity : ComponentActivity() {

    lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FEKGMonitorTheme {
                navController = rememberNavController()
                SetupNavGraph(navController = navController)
//                HomeScreen()
            }
        }
    }
}

//@Composable
//fun MyApp() {
//    FEKGMonitorTheme {
//        val allScreens = RallyScreen.values().toList()
//        var currentScreen by rememberSaveable { mutableStateOf(RallyScreen.Overview) }
//        HomeScreen()
//    }
//}
