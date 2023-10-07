package com.example.mynutri_app.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mynutri_app.components.MyAppButton
import com.example.mynutri_app.components.MyTopAppBar
import com.example.mynutri_app.home.components.Category
import com.example.mynutri_app.home.components.SearchTextField
import com.example.mynutri_app.model.RecipesSectionItems
import com.example.mynutri_app.recipes.RecipesSection

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    spacerHeight: Modifier = Modifier.height(16.dp)
) {
    Column(
        modifier = modifier.verticalScroll(rememberScrollState())
    ) {
            MyTopAppBar(
                title = "Olá! user123",
                startIcon = Icons.Default.Menu,
                endIcon = Icons.Default.Favorite,
            )
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {

            Spacer(modifier = spacerHeight)

            Row(
                modifier = modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                SearchTextField(
                    modifier = modifier
                        .weight(2f)
                        .fillMaxWidth()
                        .height(52.dp)
                )

                Spacer(modifier = modifier.width(8.dp))

                MyAppButton(
                    modifier = modifier
                        .width(120.dp)
                        .fillMaxWidth()
                        .weight(1f)
                        .height(52.dp),
                    text = "Filtrar",
                    showIcon = true,
                    buttonIcon = Icons.Default.KeyboardArrowDown
                )
            }

            Spacer(modifier = spacerHeight)

            Category()

            Spacer(modifier = spacerHeight)

            RecipesSection(containerTitle = "Mais curtidos")
            RecipesSection(containerTitle = "Relevantes")
            RecipesSection(containerTitle = "Recomendados")


        } // Column
    }
}