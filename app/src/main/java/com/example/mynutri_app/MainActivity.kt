package com.example.mynutri_app

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mynutri_app.auth.AuthScreen
import com.example.mynutri_app.home.HomeScreen
import com.example.mynutri_app.routes.AppDestination
import com.example.mynutri_app.ui.theme.MynutriappTheme

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MynutriappTheme {
                val navController = rememberNavController();
                NavHost(navController = navController, startDestination = AppDestination.AuthScreen.route) {
                        composable(AppDestination.HomeScreen.route) { HomeScreen(navController)}
                        composable(AppDestination.AuthScreen.route) { AuthScreen(navController) }
                    }
                }
            }
        }
}

