package com.example.mynutri_app.auth.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mynutri_app.ui.theme.SecondaryColor

@Composable
fun Label(
    modifier: Modifier = Modifier,
    labelText: String,
) {
    Text(text = labelText,
        style = TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            color = SecondaryColor
        ),
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 10.dp)
    )
}