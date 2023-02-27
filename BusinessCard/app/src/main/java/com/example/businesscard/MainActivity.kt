package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BusinessCard(
                        R.drawable.android_logo,
                        stringResource(R.string.my_name),
                        stringResource(R.string.company_name),
                        stringResource(R.string.phone_number),
                        stringResource(R.string.company_email_extension),
                        stringResource(R.string.email),
                        bgColor = Color(0xFF073042)
                    )
                }
            }
        }
    }
}

@Composable
fun BusinessCard(
    imageId: Int,
    name: String,
    companyName: String,
    phoneNumber: String,
    companyEmailExtension: String,
    email: String,
    bgColor: Color,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(bgColor)
    ) {
        Box(Modifier.weight(0.7f)) {
            TopView(imageId, name, companyName)
        }
        Box(Modifier.weight(0.2f)) {
            BottomView(phoneNumber, companyEmailExtension, email)
        }
    }
}

@Composable
fun TopView(
    imageId: Int,
    name: String,
    companyName: String,
) {
    val image = painterResource(imageId)
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier.size(100.dp)
        )
        Text(
            text = name,
            fontSize = 48.sp,
            color = Color.White,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = companyName,
            fontSize = 16.sp,
            color = Color(0xFF3cda82)
        )
    }
}

@Composable
fun BottomView(
    phoneNumber: String,
    companyEmailExtension: String,
    email: String
) {
    Column(Modifier.fillMaxWidth()) {
        LineInBottom(imageId = R.drawable.phone_icon, content = phoneNumber)
        LineInBottom(imageId = R.drawable.social_network_icon, content = companyEmailExtension)
        LineInBottom(imageId = R.drawable.mail_icon, content = email)
    }
}

@Composable
fun LineInBottom(imageId: Int, content: String) {
    val spaceSize = 10
    Divider(heightDp = 2)
    Space(heightDp = spaceSize)
    Row (
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .height(30.dp)
    ){
        Image(
            painter = painterResource(imageId),
            contentDescription = null,
            colorFilter = ColorFilter.tint(Color(0xFF3DDC84)),
            modifier = Modifier
                .weight(0.2f)
                .padding(start = 50.dp)
                .fillMaxHeight()
        )
        Text(
            text = content,
            fontSize = 16.sp,
            color = Color.White,
            modifier = Modifier
                .weight(0.8f)
                .padding(start = 25.dp)
        )
    }
    Space(heightDp = spaceSize)
}

@Composable
fun Divider(heightDp: Int) {
    Spacer(Modifier
        .height(heightDp.dp)
        .background(Color(0xFF526E7B))
        .fillMaxWidth()
    )
}

@Composable
fun Space(heightDp: Int) {
    Spacer(Modifier
        .height(heightDp.dp)
        .fillMaxWidth()
    )
}

@Preview(showSystemUi = true)
@Composable
fun DefaultPreview() {
    BusinessCardTheme {
        BusinessCard(
            R.drawable.android_logo,
            stringResource(R.string.my_name),
            stringResource(R.string.company_name),
            stringResource(R.string.phone_number),
            stringResource(R.string.company_email_extension),
            stringResource(R.string.email),
            bgColor = Color(0xFF073042)
        )
    }
}