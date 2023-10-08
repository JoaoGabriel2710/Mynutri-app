package com.example.mynutri_app.recipes

import android.os.Build
import androidx.annotation.DrawableRes
import androidx.annotation.Size
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mynutri_app.R
import com.example.mynutri_app.ui.theme.MynutriappTheme
import com.example.mynutri_app.ui.theme.NoImageBackground
import com.example.mynutri_app.ui.theme.PrimaryColor
import com.example.mynutri_app.ui.theme.TerciaryColor

@Composable
fun RecipeCard(
    modifier: Modifier = Modifier,
    @DrawableRes cardImage: Int? = null,
    @DrawableRes fallbackImage: Int = R.drawable.no_imageicon,
    noImageBackgroundColor: Color = NoImageBackground,
    imageShape: Shape = CircleShape,
    cardTitle: String,
    cardCategory: String,
) {
    Card(
        elevation = CardDefaults.cardElevation(6.dp),
        modifier = modifier
            .width(215.dp)
            .height(305.dp)
            .padding(end = 6.dp)
    ) {
        Box(
            modifier = modifier.fillMaxSize()
        ) {

            Surface(
                modifier = modifier
                    .fillMaxWidth()
                    .height(180.dp),
                color = PrimaryColor

            ) {} // Surface

            Image(
                painter = painterResource(id = cardImage ?: fallbackImage),
                contentDescription = "imagem do card",
                modifier = modifier
                    .size(120.dp)
                    .align(Alignment.TopCenter)
                    .offset(y = (95).dp)
                    .clip(shape = imageShape)
                    .background(noImageBackgroundColor)
            )

            Column(
                modifier = modifier
                    .fillMaxSize()
                    .padding(top = 200.dp)
                    .padding(16.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = cardTitle,
                    style = MaterialTheme.typography.headlineLarge
                )
                Text(
                    text = cardCategory,
                    modifier = modifier.padding(start = 5.dp),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun FoodCardPreview() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        MynutriappTheme {
            RecipeCard(
                cardTitle = "Titulo",
                cardCategory = "Categoria"
            )
        }
    }
}

