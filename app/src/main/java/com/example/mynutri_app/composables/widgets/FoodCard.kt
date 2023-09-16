package com.example.mynutri_app.composables.widgets

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mynutri_app.R
import com.example.mynutri_app.composables.commons.MyAppButton
import com.example.mynutri_app.ui.theme.MynutriappTheme

@Composable
fun FoodCard(
    modifier: Modifier = Modifier,
    @DrawableRes cardImage: Int? = null,
    @DrawableRes fallbackImage: Int = R.drawable.no_image,
    cardTitle: String,
    cardCategory: String
) {
    Card(
        elevation = CardDefaults.cardElevation(4.dp),
        modifier = modifier
            .width(155.dp)
            .padding(bottom = 15.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            val painter = cardImage?.let {
                painterResource(id = it)
            } ?: painterResource(id = fallbackImage)

            Image(
                painter = painter,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp) // Ajuste a altura conforme necessário
            )

            Spacer(modifier = Modifier.height(8.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = cardTitle,
                            style = TextStyle(
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                        )

                        Text(
                            text = cardCategory,
                            style = TextStyle(
                                fontSize = 12.sp
                            ),
                            modifier = Modifier.padding(top = 2.dp)
                        )
                    }


                    MyAppButton(
                        text = "Ver",
                        showIcon = false,
                        buttonIcon = Icons.Default.ArrowForward,
                        modifier = Modifier.height(33.dp).wrapContentSize()
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FoodCardPreview() {
    MynutriappTheme {
        FoodCard(
            cardTitle = "Titulo",
            cardCategory = "Categoria")
    }
}