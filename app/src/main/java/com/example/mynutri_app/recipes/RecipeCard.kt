package com.example.mynutri_app.recipes

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mynutri_app.R
import com.example.mynutri_app.ui.theme.MynutriappTheme
import com.example.mynutri_app.ui.theme.PrimaryColor

@Composable
fun RecipeCard(
    modifier: Modifier = Modifier,
    @DrawableRes cardImage: Int? = null,
    @DrawableRes fallbackImage: Int = R.drawable.no_image,
    cardTitle: String,
    cardCategory: String
) {
    Card(
        elevation = CardDefaults.cardElevation(6.dp),
        border = BorderStroke(1.dp, Color.Black),
        modifier = modifier
            .width(240.dp)
            .height(310.dp)
            .padding(end = 8.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp),
                color = PrimaryColor

            ) {} // Surface

            Image(
                painter = painterResource(id = cardImage ?: fallbackImage),
                contentDescription = null,
                modifier = Modifier
                    .size(150.dp, 130.dp)
                    .align(Alignment.TopCenter)
                    .offset(y = (100).dp)
                    .clip(CircleShape)
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 200.dp)
                    .padding(16.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = cardTitle,
                    style = TextStyle(
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
                Text(
                    text = cardCategory,
                    modifier = modifier.padding(start = 5.dp)
                )
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun FoodCardPreview() {
    MynutriappTheme {
        RecipeCard(
            cardTitle = "Titulo",
            cardCategory = "Categoria"
        )
    }
}

