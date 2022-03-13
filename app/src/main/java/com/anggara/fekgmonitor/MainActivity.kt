package com.anggara.fekgmonitor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.anggara.fekgmonitor.ui.components.FEKGTabRow
import com.anggara.fekgmonitor.ui.devices.DevicesBody
import com.anggara.fekgmonitor.ui.history.HistoryBody
import com.anggara.fekgmonitor.ui.home.HomeBody
import com.anggara.fekgmonitor.ui.theme.FEKGMonitorTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            setContent {
                FEKGApp()
            }
        }
    }

}


@Composable
fun FEKGApp() {
    FEKGMonitorTheme {
        val allScreen = FEKGScreen.values().toList()
        val navController = rememberNavController()
        val backstackEntry = navController.currentBackStackEntryAsState()
        val currentScreen = FEKGScreen.fromRoute(backstackEntry.value?.destination?.route)

        Scaffold(
            topBar = {
                FEKGTabRow(allScreen = allScreen,
                    onTabSelected = { screen ->
                        navController.navigate(screen.name)
                    },
                    currentScreen = currentScreen)
            }
        ) { innerPadding ->
            FEKGNavHost(
                navController = navController,
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}

@Composable
fun FEKGNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = FEKGScreen.Home.name,
        modifier = modifier
    ) {
        composable(FEKGScreen.Home.name) {
            HomeBody()
        }
        composable(FEKGScreen.History.name) {
            HistoryBody()
        }
        composable(FEKGScreen.Devices.name) {
            DevicesBody()
        }

    }
}

@Preview(showBackground = true)
@Composable
fun MyPreview() {
    FEKGApp()
}
