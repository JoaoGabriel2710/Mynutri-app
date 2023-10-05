package com.example.mynutri_app.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mynutri_app.components.MyAppButton
import com.example.mynutri_app.components.MyTopAppBar
import com.example.mynutri_app.home.components.Category
import com.example.mynutri_app.home.components.SearchTextField
import com.example.mynutri_app.model.RecipeCardItem
import com.example.mynutri_app.recipes.RecipeCard
import com.example.mynutri_app.ui.theme.MynutriappTheme

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        MyTopAppBar(
            title = "Olá! user123",
            startIcon = Icons.Default.Menu,
            endIcon = Icons.Default.Favorite,
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            SearchTextField(modifier = Modifier
                .weight(2f)
                .fillMaxWidth()
                .height(52.dp))

            Spacer(modifier = Modifier.width(8.dp))

            MyAppButton(
                modifier = Modifier.width(120.dp)
                    .fillMaxWidth()
                    .weight(1f)
                    .height(52.dp),
                text = "Filtrar",
                showIcon = true,
                buttonIcon = Icons.Default.KeyboardArrowDown
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Category()

        Spacer(modifier = Modifier.height(16.dp))

        val recipeCardList = List(7) {
            RecipeCardItem(cardTitle = "Titulo", cardCategory = "Categoria")
        }

       LazyRow {
           items(recipeCardList) {
               item -> RecipeCard(
               cardTitle = item.cardTitle,
               cardCategory = item.cardCategory)
           }
       }
    }
}



@Preview(showBackground = true)
@Composable
fun HomePreview() {
    MynutriappTheme {
        HomeScreen()
    }
}