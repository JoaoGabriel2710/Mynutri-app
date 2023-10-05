package com.example.mynutri_app.home.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mynutri_app.ui.theme.MynutriappTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchTextField(
    keyboardType: KeyboardType = KeyboardType.Text,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = "",
        onValueChange = {},
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = keyboardType
        ),
        leadingIcon = {
            Icon(imageVector = Icons.Default.Search, contentDescription = null)
        },
        placeholder = {
            Text(text = "Buscar receita..")
        },
        textStyle = TextStyle(
            fontSize = 16.sp,
            color = Color.Black
        ),
        modifier = modifier,
        shape = RoundedCornerShape(6.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun TextFieldPreview(){
    MynutriappTheme {
        Row(modifier = Modifier.fillMaxSize()) {
            SearchTextField()
        }
    }
}