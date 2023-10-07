package com.example.mynutri_app.auth.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mynutri_app.model.Validation
import com.example.mynutri_app.ui.theme.MynutriappTheme
import com.example.mynutri_app.ui.theme.PrimaryColor
import com.example.mynutri_app.ui.theme.SecondaryColor
import com.example.mynutri_app.ui.theme.TerciaryColor

@Composable
fun AuthScreen(
    modifier: Modifier = Modifier,
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val SpacerHeight = modifier.height(35.dp)


    var errorMessage by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(PrimaryColor)
    ) {
        Text(
            text = "Seja bem Vindo(a)",
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = SecondaryColor
            )
        )

        Spacer(modifier = modifier.weight(1f))

        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .weight(2f),
            shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp),
            color = TerciaryColor
        ) {
            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = modifier
                    .fillMaxSize()
                    .padding(8.dp)
            ) {
                Text(
                    text = "Faça seu Login",
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp),
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp,
                        letterSpacing = 0.6.sp,
                        color = SecondaryColor
                    )
                )

                Spacer(modifier = SpacerHeight)

                Label(labelText = "Email")
                MyTextField(
                    text = email,
                    onValueChange = { newValue ->
                        email = newValue
                    },
                    labelText = "Seu email",
                    errorMessage = "Email inválido",
                    keyboardType = KeyboardType.Email,
                    isEmail = true
                )

                Label(labelText = "Senha")
                MyTextField(
                    text = password,
                    onValueChange = { newValue ->
                        password = newValue
                    },
                    labelText = "Sua senha",
                    errorMessage = "Senha inválida",
                    keyboardType = KeyboardType.Password,
                    isPassword = true
                )

                Text(
                    text = "Esqueci minha Senha",
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp),
                    color = SecondaryColor
                )

                Spacer(modifier = SpacerHeight)

                Button(
                    onClick = {
                        if (email.isNotEmpty() && Validation.isValidEmail(email) &&
                            password.isNotEmpty() && Validation.isValidPassword(password))
                        {

                        } else {
                            errorMessage = "Por favor, preencha todos os campos";
                        }
                    },
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp)
                        .height(55.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = SecondaryColor
                    ),
                    shape = RoundedCornerShape(6.dp)
                ) {
                    Text(
                        text = "Entrar",
                        fontSize = 18.sp
                    )
                }

                if(errorMessage.isNotEmpty()) {
                    Text(
                        text = errorMessage,
                        style = TextStyle(
                            textAlign = TextAlign.Start,
                            color = Color.Red
                        ),
                        modifier = modifier
                            .fillMaxWidth()
                    )
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun AuthScreenPreview() {
    MynutriappTheme {
        AuthScreen()
    }
}