package com.example.mynutri_app.composables.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
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
import com.example.mynutri_app.composables.commons.Header
import com.example.mynutri_app.composables.commons.MyAppButton
import com.example.mynutri_app.composables.widgets.Category
import com.example.mynutri_app.composables.widgets.FoodCard
import com.example.mynutri_app.composables.widgets.SearchTextField
import com.example.mynutri_app.ui.theme.MynutriappTheme

data class FoodCardItem(
    val cardTitle: String,
    val cardCategory: String
);

@Composable
fun Home() {
    val reutilizableModifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 3.dp, vertical = 8.dp)

    val spacerHeight = Modifier.height(16.dp)
    Column(
        modifier = Modifier.padding(horizontal = 3.dp)
    ) {
        Header(
            title = "Olá! user123",
            startIcon = Icons.Default.Menu,
            endIcon = Icons.Default.Favorite
        )
        Spacer(modifier = spacerHeight)
        Row(
            modifier = reutilizableModifier,
            verticalAlignment = Alignment.CenterVertically
        ) {
            FilterButtonAndSearch()
        }
        Spacer(modifier = spacerHeight)

        Category()

        Spacer(modifier = spacerHeight)

        val foodCardList = listOf(
            FoodCardItem(cardTitle = "Titulo", cardCategory = "Categoria"),
            FoodCardItem(cardTitle = "Titulo", cardCategory = "Categoria"),
            FoodCardItem(cardTitle = "Titulo", cardCategory = "Categoria"),
            FoodCardItem(cardTitle = "Titulo", cardCategory = "Categoria"),
            FoodCardItem(cardTitle = "Titulo", cardCategory = "Categoria"),

        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            LazyColumn(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                items(foodCardList) { item ->
                    FoodCard(
                        cardTitle = item.cardTitle,
                        cardCategory = item.cardCategory
                    );
                }
            }

            LazyColumn(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(top = 40.dp)
            ) {
                items(foodCardList) { item ->
                    FoodCard(
                        cardTitle = item.cardTitle,
                        cardCategory = item.cardCategory
                    );
                }
            }
        } // Row
    }
}

@Composable
fun FilterButtonAndSearch() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        SearchTextField()

        Spacer(modifier = Modifier.width(8.dp))
        MyAppButton(
            modifier = Modifier.weight(1f),
            text = "Filtrar",
            showIcon = true,
            buttonIcon = Icons.Default.KeyboardArrowDown
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    MynutriappTheme {
        Home()
    }
}