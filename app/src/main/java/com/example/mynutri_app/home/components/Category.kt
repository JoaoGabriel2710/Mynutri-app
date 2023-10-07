package com.example.mynutri_app.home.components

import android.os.Build
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mynutri_app.R
import com.example.mynutri_app.model.CategoryCardsItem
import com.example.mynutri_app.ui.theme.MynutriappTheme
import com.example.mynutri_app.ui.theme.PrimaryColor


@Composable
fun Category(
    modifier: Modifier = Modifier
) {
    val categoryCardList = listOf(
        CategoryCardsItem(
            image = R.drawable.icone_pretreino,
            cardTitle = "Pre-Treino"),
        CategoryCardsItem(
            image = R.drawable.icone_postreino,
            cardTitle = "Pos-Treino"),
        CategoryCardsItem(
            image = R.drawable.icone_lanche,
            cardTitle = "Lanche"),
        CategoryCardsItem(
            image = R.drawable.icone_bebidas,
            cardTitle = "Bebidas"),
        CategoryCardsItem(
            image = R.drawable.icone_lowcarb,
            cardTitle = "Low carb"),
    );

    Column {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = modifier.fillMaxWidth()
        ) {
            Text(
                text = "Categorias",
                style = TextStyle(
                    fontSize = 19.sp,
                    fontWeight = FontWeight.SemiBold
                  )
                );

            IconButton(
                onClick = { /*TODO*/ }) {
                Icon(
                    painter = painterResource(id = R.drawable.more_icon),
                    contentDescription = null,
                    modifier = modifier.size(28.dp)
                )
            }
        }

        Spacer(modifier = modifier.height(5.dp))
        LazyRow {
            items(categoryCardList) { item ->
                CategoryCard(
                    image = item.image,
                    cardTitle = item.cardTitle
                )
            }
        }
    }
}

@Composable
fun CategoryCard(
    modifier: Modifier = Modifier,
    @DrawableRes image: Int,
    cardTitle: String,
    borderColor: Color = PrimaryColor,
) {
    Surface(
        modifier = modifier
            .width(100.dp)
            .shadow(4.dp)
            .padding(end = 5.dp),
        border = BorderStroke(2.dp, borderColor),
        shape = RoundedCornerShape(6.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = modifier
                .height(130.dp)
                //.padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = null,
                modifier = modifier.size(60.dp)
            )
            Spacer(modifier = modifier.height(10.dp))

            Text(
                text = cardTitle,
                style = TextStyle(
                    textAlign = TextAlign.Center,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                ),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CategoryPreview() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        MynutriappTheme {
            Surface(modifier = Modifier.fillMaxSize()) {
                Category();
            }
        }
    }
}