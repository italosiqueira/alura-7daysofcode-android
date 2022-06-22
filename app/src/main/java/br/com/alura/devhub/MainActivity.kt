package br.com.alura.devhub

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import br.com.alura.devhub.ui.theme.DevHubTheme
import br.com.alura.devhub.webclient.RetrofitInit
import coil.compose.AsyncImage
import coil.request.ImageRequest
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launch {
            RetrofitInit().gitHubService.findProfileBy("italosiqueira")
                .let {
                    Log.i("MainActivity", "onCreate: $it")
                }
        }

        setContent {
            DevHubTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ProfileScreen();
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreen() {
    DevHubTheme {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val  boxHeight = remember {
                150.dp
            }

            val imageHeight = remember {
                boxHeight
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = Color(0xFF2d333b),
                        shape = RoundedCornerShape(
                            bottomEnd = 16.dp,
                            bottomStart = 16.dp,
                        )
                    )
                    .height(boxHeight)
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data("https://avatars.githubusercontent.com/u/1196586?v=4")
                        .crossfade(true)
                        .build(),
                    placeholder = painterResource(R.drawable.profile_picture_placeholder),
                    contentDescription = "Profile Picture",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .offset(y = imageHeight / 2)
                        // Set image size to 80 dp
                        .size(imageHeight)
                        .align(Alignment.BottomCenter)
                        // Clip image to be shaped as a circle
                        .clip(CircleShape)
                )
            }

            // Add a horizontal space between the image and the column
            Spacer(modifier = Modifier.height(imageHeight / 2))

            Text(
                text = "Italo Siqueira Lima",
                style = MaterialTheme.typography.h6
            )
            Text(
                text = "@italosiqueira",
                style = MaterialTheme.typography.caption,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Desenvolvedor e Analista de Sistemas", style
                = MaterialTheme.typography.body2
            )
        }
    }
}