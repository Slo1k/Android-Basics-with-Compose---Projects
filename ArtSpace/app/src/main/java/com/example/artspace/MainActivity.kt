package com.example.artspace

import android.os.Bundle
import android.text.style.StyleSpan
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ArtSpaceScreenApp()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceScreenApp() {
    var currentPicture by remember {  mutableStateOf(1) }
    val pictureResource = when(currentPicture) {
        1 -> painterResource(id = R.drawable.dragon_ball)
        2 -> painterResource(id = R.drawable.piekielny_raj)
        else -> painterResource(id = R.drawable.atelier)
    }
    val pictureTitle = when(currentPicture) {
        1 -> stringResource(R.string.dragon_ball_title)
        2 -> stringResource(R.string.piekielny_raj_title)
        else -> stringResource(R.string.atelier_title)
    }
    val pictureAuthor = when(currentPicture) {
        1 -> stringResource(R.string.dragon_ball_author)
        2 -> stringResource(R.string.piekilny_raj_author)
        else -> stringResource(R.string.atelier_author)
    }
    val pictureYear = when(currentPicture) {
        1 -> stringResource(R.string.dragon_ball_year)
        2 -> stringResource(R.string.piekilny_raj_year)
        else -> stringResource(R.string.atelier_year)
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 30.dp, start = 20.dp, end = 20.dp, bottom = 15.dp)
    ) {
        Image(
            painter = pictureResource,
            contentDescription = null,
            modifier = Modifier
                .weight(0.5F)
                .border(3.dp, Color.Gray)
                .padding(30.dp)
        )
        Spacer(modifier = Modifier.weight(0.1F))
        Text(
            buildAnnotatedString {
                withStyle(style = SpanStyle(fontSize = 30.sp)) {
                    append(pictureTitle)
                }
                append("\n")
                withStyle(style = SpanStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold)) {
                    append(pictureAuthor)
                }
                withStyle(style = SpanStyle(fontSize = 20.sp)) {
                    append(pictureYear)
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .weight(0.3F)
                .shadow(3.dp)
                .padding(15.dp)

        )
        Row(
            modifier = Modifier
                .weight(0.1F)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom
        ) {
            Button(
                onClick = {
                    if(currentPicture > 1) {
                        currentPicture--
                    } else {
                        currentPicture = 3
                    }
                },
                modifier = Modifier
                    .weight(0.9F)
            ) {
                Text(
                    text = "Previous"
                )
            }
            Spacer(modifier = Modifier.weight(0.1F))
            Button(
                onClick = {
                    if (currentPicture < 3) {
                        currentPicture++
                    } else {
                        currentPicture = 1
                    }
                          },
                modifier = Modifier
                    .weight(0.9F)
            ) {
                Text(
                    text = "Next"
                )
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtSpaceTheme {
        ArtSpaceScreenApp()
    }
}