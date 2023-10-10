iimport android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardController
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SplashScreen()
        }
    }
}

@Composable
fun SplashScreen() {
    var showScreen by remember { mutableStateOf(true) }
    val scope = rememberCoroutineScope()
    val keyboardController = remember { mutableStateOf<KeyboardController?>(null) }

    LaunchedEffect(showScreen) {
        delay(2000)
        showScreen = false
    }

    Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (showScreen) {
            Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center,
            )

            Triangle()


            Text(
                    text = "MyNutri",
                    style = MaterialTheme.typography.h4,
                    color = Color.Black,
                    modifier = Modifier.padding(top = 16.dp)
            )
        } else {
            Button(
                    onClick = {
                    },
                    modifier = Modifier.fillMaxWidth()
                            .background(color = Color.primary_color)
            ) {
                Text(text = "Entrar")
            }

            Button(
                    onClick = {
                    },
                    modifier = Modifier.fillMaxWidth()
                            .background(color = Color.White)
            ) {
                Text(text = "Cadastrar Conta"),
                 color = Color.Black,
            }
        }
    }
}

@Composable
fun Triangle() {
    Canvas(
            modifier = Modifier
                    .size(100.dp)
                    .padding(8.dp)
    ) {
        val path = Path()
        path.moveTo(size.width / 2, 0f)
        path.lineTo(size.width, size.height)
        path.lineTo(0f, size.height)
        path.close()
        drawPath(path, color = Color.primary_color)
    }
}

