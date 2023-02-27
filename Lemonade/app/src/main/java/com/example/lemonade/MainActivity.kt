package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
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
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LemonadeApp()
                }
            }
        }
    }
}

class PageElements(var textId: Int, var imageId: Int, var totalTap: Int)

@Composable
fun LemonadeApp(modifier: Modifier = Modifier) {
    var pageNumber by remember { mutableStateOf(1) }
    var pageElements = when(pageNumber) {
        1 -> PageElements(R.string.lemon_tree, R.drawable.lemon_tree, 1)
        2 -> PageElements(R.string.lemon_squeeze, R.drawable.lemon_squeeze, (2..4).random())
        3 -> PageElements(R.string.lemon_drink, R.drawable.lemon_drink, 1)
        else -> PageElements(R.string.lemon_restart, R.drawable.lemon_restart, 1)
    }
    var tapCount by remember { mutableStateOf(0) }

    if (tapCount >= pageElements.totalTap) {
        pageNumber = if (pageNumber < 4) pageNumber + 1 else 1
        tapCount = 0
    }

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(pageElements.textId),
            fontSize = 18.sp,
        )
        Spacer(modifier = Modifier.height(16.dp))
        Image(
            painter = painterResource(pageElements.imageId),
            contentDescription = null,
            modifier = Modifier
                .clickable(onClick = { tapCount += 1 })
                .border(
                    BorderStroke(2.dp, Color(105, 205, 216)),
                    shape = RoundedCornerShape(4.dp)
                )
        )
    }
}


@Preview(showSystemUi = true)
@Composable
fun DefaultPreview() {
    LemonadeTheme {
        LemonadeApp()
    }
}