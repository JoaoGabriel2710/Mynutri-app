package com.example.mynutri_app.home.components

import android.os.Build
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mynutri_app.ui.theme.MynutriappTheme

@Composable
fun SearchTextField(
    keyboardType: KeyboardType = KeyboardType.Text,
    modifier: Modifier = Modifier,
    searchIcon: ImageVector = Icons.Default.Search,
    borderRadius: RoundedCornerShape = RoundedCornerShape(6.dp)
) {
    OutlinedTextField(
        value = "",
        onValueChange = {},
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = keyboardType
        ),
        leadingIcon = {
            Icon(
                imageVector = searchIcon,
                contentDescription = "Icone de uma lupa",
            )
        },
        placeholder = {
            Text(
                text = "Buscar receita..",
                style = TextStyle(fontSize = 16.sp)
            )
        },

        modifier = modifier,
        shape = borderRadius
    )
}

@Preview(showBackground = true)
@Composable
fun TextFieldPreview(){
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        MynutriappTheme {
            Row(modifier = Modifier.fillMaxSize()) {
                SearchTextField()
            }
        }
    }
}