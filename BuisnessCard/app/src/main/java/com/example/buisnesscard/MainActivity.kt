package com.example.buisnesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.buisnesscard.ui.theme.BuisnessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BuisnessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0x592596be)
                ) {
                    BusinessCardApp(
                        nameSurname = "Jennifer Doe",
                        phoneNumber = "+11 (123) 444 555 666",
                        socials = "@AndroidDev",
                        email = "jen.doe@android.com")
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp(nameSurname: String, phoneNumber: String, socials: String, email: String) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.background(Color(0xFF003F54))) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .weight(4f)
        ) {
            val image = painterResource(id = R.drawable.android_logo)
            Image(
                painter = image,
                contentDescription = null,
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp)
            )
            Text(
                text = nameSurname,
                fontSize = 35.sp,
                color = Color.White,
                modifier = Modifier
                    .padding(bottom = 10.dp)
            )
            Text(
                text = stringResource(R.string.android_developer),
                color = Color(0xFF3ddc84),
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(bottom = 40.dp),
            verticalArrangement = Arrangement.Bottom
        ) {
            Box(modifier = Modifier.fillMaxWidth().height(1.dp).background(Color.Gray))
            Row(
                modifier = Modifier
                    .padding(top = 5.dp, bottom = 5.dp, start = 40.dp)
            ) {
                val phoneIcon = painterResource(id = R.drawable.ic_baseline_local_phone_24).apply {
                    Image(
                        painter = this,
                        contentDescription = stringResource(R.string.phone_icon_desc),
                        modifier = Modifier
                            .padding(end = 20.dp)
                    )
                }
                Text(
                    text = phoneNumber,
                    color = Color.White
                )
            }
            Box(modifier = Modifier.fillMaxWidth().height(1.dp).background(Color.Gray))
            Row(
                modifier = Modifier
                    .padding(top = 5.dp, bottom = 5.dp, start = 40.dp)
            ) {
                val shareIcon = painterResource(id = R.drawable.ic_baseline_share_24)
                Image(
                    painter = shareIcon,
                    contentDescription = stringResource(R.string.share_icon_desc),
                    modifier = Modifier
                        .padding(end = 20.dp)
                )
                Text(
                    text = socials,
                    color = Color.White
                )
            }
            Box(modifier = Modifier.fillMaxWidth().height(1.dp).background(Color.Gray))
            Row(
                modifier = Modifier
                    .padding(top = 5.dp, bottom = 5.dp, start = 40.dp)
            ) {
                val emailIcon = painterResource(id = R.drawable.ic_baseline_email_24)
                Image(
                    painter = emailIcon,
                    contentDescription = stringResource(R.string.email_icon_desc),
                    modifier = Modifier
                        .padding(end = 20.dp)
                )
                Text(
                    text = email,
                    color = Color.White
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BuisnessCardTheme {
        BusinessCardApp(
            nameSurname = "Jennifer Doe",
            phoneNumber = "+11 (123) 444 555 666",
            socials = "@AndroidDev",
            email = "jen.doe@android.com")
    }
}
