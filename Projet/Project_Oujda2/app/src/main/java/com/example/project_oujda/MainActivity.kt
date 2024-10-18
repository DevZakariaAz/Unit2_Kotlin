package com.example.project_oujda

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = colorScheme.background
            ) {
                // Call the GreetingImage composable
                GreetingImage()
            }
        }
    }
}

@Composable
fun GreetingImage() {
    var showFirstImage by remember { mutableStateOf(true) }

    Box(modifier = Modifier.fillMaxSize()) {
        val backgroundImage = painterResource(R.drawable.mosquee_oujda)
        Image(
            painter = backgroundImage,
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        val transparentColor = Color(0x80FFFFFF)
        Box(
            modifier = Modifier
                .padding(16.dp)
                .border(
                    width = 2.dp,
                    color = Color.Gray,
                    shape = RoundedCornerShape(16.dp)
                )
                .background(
                    color = transparentColor,
                    shape = RoundedCornerShape(16.dp)
                )
                .padding(16.dp)
                .align(Alignment.Center)
        ) {
            Column(
                // Center the content of the column
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                // Assign appropriate image based on condition
                val foregroundImage = if (showFirstImage) {
                    painterResource(R.drawable.oujda_jama3)
                } else {
                    painterResource(R.drawable.bab_sidi_abdel_wahabjpg)
                }

                Image(
                    painter = foregroundImage,
                    contentDescription = null,
                    modifier = Modifier.size(150.dp)
                )

                // Spacer between the image and text
                Spacer(modifier = Modifier.height(16.dp))

                // Add the text content
                if (showFirstImage) {
                    CarteDeVisitContent(
                        description = "Oujda is the capital city of the Oriental region of northeastern Morocco",
                        address = "Mosque Of Omar Bin Abdul Aziz, Oujda"
                    )
                } else {
                    CarteDeVisitContent(
                        description = "Oujda is a city in northeast Morocco. It’s known for its Great Mosque",
                        address = "La mosquée Al Jamaa Al Kabir, Oujda, Maroc"
                    )
                }

                // Spacer between the text and button
                Spacer(modifier = Modifier.height(16.dp))

                // Add Button to switch image
                Button(onClick = {
                    showFirstImage = !showFirstImage
                }) {
                    Text(text = "Switch Image")
                }
            }
        }
    }
}

@Composable
fun CarteDeVisitContent(modifier: Modifier = Modifier, description: String, address: String) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        // City name
        Text(
            text = "City is Oujda",
            modifier = modifier.padding(8.dp),
            fontSize = 24.sp,
            lineHeight = 30.sp,
            textAlign = TextAlign.Center
        )
        // Description about the city
        Text(
            text = description,
            fontSize = 18.sp,
            modifier = modifier.padding(4.dp)
        )
        // Address of the city
        Text(
            text = address,
            fontSize = 16.sp,
            modifier = modifier.padding(4.dp)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CarteDeVisitPreview() {
    GreetingImage()
}
