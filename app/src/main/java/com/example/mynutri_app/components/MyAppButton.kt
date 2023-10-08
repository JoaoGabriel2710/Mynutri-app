package com.example.mynutri_app.components

import android.os.Build
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mynutri_app.ui.theme.MynutriappTheme
import com.example.mynutri_app.ui.theme.PrimaryColor
import com.example.mynutri_app.ui.theme.SecondaryColor

@Composable
fun MyAppButton(
    modifier: Modifier = Modifier,
    text: String,
    buttonIcon: ImageVector? = null,
    backgroundColor: Color,
    borderRadius: RoundedCornerShape = RoundedCornerShape(6.dp),
) {
    Button(
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor
        ),
        shape = borderRadius,
        modifier = modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = text)
            Spacer(modifier = Modifier.width(3.dp))
            if (buttonIcon != null) {
                Icon(
                    imageVector = buttonIcon,
                    contentDescription = null
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ButtonPreview() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        MynutriappTheme {
            MyAppButton(
                text = "Filtrar",
                backgroundColor = SecondaryColor,
                buttonIcon = Icons.Default.KeyboardArrowDown
            )
        }
    }
}