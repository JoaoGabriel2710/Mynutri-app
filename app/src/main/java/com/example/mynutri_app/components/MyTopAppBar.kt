package com.example.mynutri_app.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.mynutri_app.ui.theme.MynutriappTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(
    modifier: Modifier = Modifier,
    title: String,
    startIcon: ImageVector,
    endIcon: ImageVector,
) {
    var isExpanded by remember { mutableStateOf(false) }

    TopAppBar(
        title = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = title,
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    ),
                )
            }
        },
        navigationIcon = {
            IconButton(
                onClick = { isExpanded = true }
            ) {
                Icon(imageVector = startIcon, contentDescription = null)
            }
            DropdownMenu(
                expanded = isExpanded,
                onDismissRequest = { isExpanded = false }) {

                DropdownMenuItem(
                    text = { Text(text = "Meu perfil") },
                    onClick = { isExpanded = false },
                    trailingIcon = {
                        Icon(imageVector = Icons.Default.Person, contentDescription = "Icone de usuario");
                    }
                )

                DropdownMenuItem(
                    text = { Text(text = "Configurações") },
                    onClick = { isExpanded = false },
                    trailingIcon = {
                        Icon(imageVector = Icons.Default.Settings, contentDescription = "Icone de engrenagem para configurações");
                    }
                )

                DropdownMenuItem(
                    text = { Text(text = "Sair") },
                    onClick = { isExpanded = false },
                    trailingIcon = {
                        IconButton(
                            onClick = {

                            }
                        ) {
                            Icon(imageVector = Icons.Default.ExitToApp, contentDescription = "Icone de saida para logout")
                        }
                    }
                )
            }
        },
        actions = {
            IconButton(
                onClick = { /*TODO*/ }
            ) {
                Icon(imageVector = endIcon, contentDescription = null)
            }
        }
    )
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview (showBackground = true)
@Composable
fun HeaderPreview(){
    MynutriappTheme {
        MyTopAppBar(
            title = "Ola! user123",
            startIcon = Icons.Default.Menu,
            endIcon = Icons.Default.Favorite)
    }
}