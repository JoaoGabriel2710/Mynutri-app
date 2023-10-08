package com.example.mynutri_app.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.navigation.NavController
import com.example.mynutri_app.components.MyAppButton
import com.example.mynutri_app.components.MyTopAppBar
import com.example.mynutri_app.home.components.Category
import com.example.mynutri_app.home.components.SearchTextField
import com.example.mynutri_app.recipes.RecipesSection
import com.example.mynutri_app.ui.theme.SecondaryColor

@Composable
fun HomeScreen(
    navController: NavController,
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
                        .weight(2.3f)
                        .fillMaxWidth()
                        .height(54.dp)
                )

                Spacer(modifier = modifier.width(8.dp))

                MyAppButton(
                    modifier = modifier
                        .width(120.dp)
                        .fillMaxWidth()
                        .weight(1f)
                        .height(54.dp),
                    text = "Filtrar",
                    buttonIcon = Icons.Default.KeyboardArrowDown,
                    backgroundColor = SecondaryColor
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