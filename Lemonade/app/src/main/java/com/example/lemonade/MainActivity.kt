package com.example.lemonade

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                LemonApp()
            }
        }
    }
}

@Composable
fun LemonApp() {
    // A surface container using the 'background' color from the theme
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        var step by remember { mutableStateOf(1)}
        var squeezeCount by remember { mutableStateOf(0)}
        val imageResource = when(step) {
            1 -> R.drawable.lemon_tree
            2 -> R.drawable.lemon_squeeze
            3 -> R.drawable.lemon_drink
            else -> R.drawable.lemon_restart
        }
        val textResource = when(step) {
            1 -> R.string.lemon_tree_text
            2 -> R.string.lemon_text
            3 -> R.string.glass_text
            else -> R.string.empty_glass_text
        }
        val imgResourceDesc = when(step) {
            1 -> R.string.lemon_tree
            2 -> R.string.lemon
            3 -> R.string.glass
            else -> R.string.empty_glass
        }
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = textResource),
                fontSize = 18.sp
            )
            Spacer(modifier = Modifier.height(16.dp))
            Image(
                painter = painterResource(id = imageResource),
                contentDescription = stringResource(id = imgResourceDesc),
                modifier = Modifier
                    .border(2.dp, Color(105, 205, 216))
                    .clickable {
                        if (step == 4){
                            step = 1
                        } else {
                            if (step == 1){
                                squeezeCount = (2..4).random()
                                step++
                            }
                            else if (step == 2){
                                squeezeCount--
                                if (squeezeCount == 0){
                                    step++
                                }
                            }
                            else {
                                step++
                            }
                        }
                    }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LemonadeTheme {
        LemonApp()
    }
}
