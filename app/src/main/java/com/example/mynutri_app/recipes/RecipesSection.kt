package com.example.mynutri_app.recipes

import android.os.Build
import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mynutri_app.R
import com.example.mynutri_app.model.RecipeCardItem
import com.example.mynutri_app.ui.theme.MynutriappTheme
import com.example.mynutri_app.ui.theme.TerciaryColor


@Composable
fun RecipesSection(
    modifier: Modifier = Modifier,
    containerTitle: String,
    @DrawableRes iconSeeMore: Int = R.drawable.more_icon,
    spaceHeight: Modifier = Modifier.height(10.dp),
) {
    val recipeCardList = List(7) {
        RecipeCardItem(cardTitle = "Titulo", cardCategory = "Categoria")
    }
    var isExpanded by remember { mutableStateOf(false) }

    Column(
        modifier = modifier.fillMaxSize()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = modifier.fillMaxWidth()
        ) {
            Text(
                text = containerTitle,
                style = MaterialTheme.typography.headlineSmall
                )

                IconButton(
                    onClick = {
                        isExpanded = true
                    }
                ) {
                Icon(
                    painter = painterResource(id = iconSeeMore),
                    contentDescription = "Icone de três pontos",
                    modifier = modifier.size(28.dp)
                )

                DropdownMenu(
                    expanded = isExpanded,
                    onDismissRequest = { isExpanded = false },
                    modifier = modifier.background(TerciaryColor)
                ) {
                    DropdownMenuItem(text = {
                       Text(text = "Ver mais")
                    }, onClick = { /*TODO*/ })
                }
            }
        }

        Spacer(modifier = spaceHeight)
        LazyRow {
            items(recipeCardList) { item ->
                RecipeCard(
                    cardTitle = item.cardTitle,
                    cardCategory = item.cardCategory
                )
            }
        } // LazyRow
    } // Column
    Spacer(modifier = modifier.height(16.dp))
}

@Preview(showBackground = true)
@Composable
fun RecipesPreview() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        MynutriappTheme {
            RecipesSection(containerTitle = "Recomendados")
        }
    }
}