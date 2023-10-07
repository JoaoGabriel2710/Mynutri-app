package com.example.mynutri_app

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.mynutri_app.auth.components.AuthScreen
import com.example.mynutri_app.home.HomeScreen
import com.example.mynutri_app.ui.theme.MynutriappTheme

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MynutriappTheme {
                    HomeScreen()
                }
            }
        }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        MynutriappTheme {
            HomeScreen()
        }
    }
}
