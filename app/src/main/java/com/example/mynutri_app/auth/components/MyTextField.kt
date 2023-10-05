package com.example.mynutri_app.auth.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mynutri_app.model.Validation
import com.example.mynutri_app.ui.theme.MynutriappTheme
import com.example.mynutri_app.ui.theme.PrimaryColor
import com.example.mynutri_app.ui.theme.SecondaryColor

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun MyTextField(
    modifier: Modifier = Modifier,
    text: String,
    onValueChange: (String) -> Unit,
    labelText: String,
    isPassword: Boolean = false,
    isEmail: Boolean = false,
    errorMessage: String,
    keyboardType: KeyboardType,
    topAndBottomPadding: Modifier = Modifier.padding(top = 2.dp, bottom = 2.dp),
) {
    var isError by remember { mutableStateOf(false) }
    val focusManager = LocalFocusManager.current;

    OutlinedTextField(
        value = text,
        onValueChange = {
            onValueChange(it);
            isError = false;
        },
        label = { Text(text = labelText) },
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType,
            imeAction = ImeAction.Done,
        ),
        keyboardActions = KeyboardActions(
            onDone = {
                val isValid =
                    if(isEmail) Validation.isValidEmail(text)
                    else Validation.isValidPassword(text)

                    if(!isValid) isError = true

                if (!isError) focusManager.moveFocus(FocusDirection.Down)

            }
        ),
        isError = isError,
        trailingIcon = {
            if (isError) {
                Icon(
                    imageVector = Icons.Outlined.Info,
                    contentDescription = "Icone avisando um erro",
                    modifier = topAndBottomPadding
                )
            }
        },
        colors = TextFieldDefaults.textFieldColors(
            textColor = SecondaryColor,
            containerColor = Color.Transparent,
            focusedIndicatorColor = SecondaryColor,
            unfocusedIndicatorColor = SecondaryColor,
            errorIndicatorColor = Color.Red
        ),
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp)
    )

    if (isError) {
        Text(
            text = errorMessage,
            color = Color.Red,
            fontSize = 12.sp,
            textAlign = TextAlign.Start,
            modifier = modifier.fillMaxWidth()
        )
    }

}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun MyTextFieldPreview() {
    var text by remember { mutableStateOf("") }

    MynutriappTheme {
        MyTextField(
            text = text,
            onValueChange = { newText ->
                text = newText
            },
            labelText = "Email",
            errorMessage = "Email inválido!",
            keyboardType = KeyboardType.Text,
            isEmail = true,
        )
    }
}

