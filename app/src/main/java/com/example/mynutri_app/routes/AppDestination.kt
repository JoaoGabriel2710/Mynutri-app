package com.example.mynutri_app.routes

sealed class AppDestination(val route: String) {
    object HomeScreen : AppDestination("home");
    object AuthScreen : AppDestination("auth");
}