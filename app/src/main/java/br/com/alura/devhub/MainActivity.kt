package br.com.alura.devhub

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.alura.devhub.ui.theme.DevHubTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DevHubTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column {
                        Image(
                            painter = painterResource(id = R.drawable.profile_picture),
                            contentDescription = "Profile Picture"
                        )

                        // Add a horizontal space between the image and the column
                        Spacer(modifier = Modifier.height(8.dp))

                        Text(text = "Desenvolvedor e Analista de Sistemas")
                        Text(text = "Italo Siqueira Lima")
                        Text(text = "italosiqueira")
                    }
                }
            }
        }
    }
}

data class OutputTextField(val label: String, val content: String)

@Composable
fun DisplayTextField(field: OutputTextField) {
    Text(text = "${field.label}: ${field.content}")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DevHubTheme {
//        DisplayTextField(OutputTextField("Nome", "Italo Siqueira Lima"))
        Column {
            Image(
                painter = painterResource(id = R.drawable.profile_picture),
                contentDescription = "Profile Picture",
                modifier = Modifier
                    // Set image size to 40 dp
                    .size(80.dp)
                    // Clip image to be shaped as a circle
                    .clip(CircleShape)
            )

            // Add a horizontal space between the image and the column
            Spacer(modifier = Modifier.height(8.dp))

            Text(text = "Italo Siqueira Lima")
            Text(text = "italosiqueira")
            Text(text = "Desenvolvedor e Analista de Sistemas")
        }
    }
}