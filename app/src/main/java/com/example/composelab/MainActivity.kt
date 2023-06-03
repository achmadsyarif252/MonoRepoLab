package com.example.composelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composelab.ui.theme.ComposeLabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeLabTheme {
                val navController = rememberNavController()
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    HomePage(navHostController = navController)
                }
            }
        }
    }

    @Composable
    fun HomePage(
        navHostController: NavHostController
    ) {
        NavHost(navController = navHostController, startDestination = Screen.HomePageScren.route) {
            composable(Screen.HomePageScren.route) {
                DashboardScreen {
                    navHostController.navigate(Screen.DetailScreen.route)
                }
            }

            composable(Screen.DetailScreen.route) {
                DetailScreen()
            }
        }
    }
}

@Composable
fun DashboardScreen(onButtonClicked: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Welcome To Dashboard")
        Button(onClick = onButtonClicked) {
            Text("Click Me")
        }
    }
}


@Composable
fun DetailScreen() {
    Text(
        "This is detail screen",
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxSize()
    )
}
