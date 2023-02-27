package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
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
import com.example.artspace.ui.theme.ArtSpaceTheme
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.shadow

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
                    ArtSpacePage()
                }
            }
        }
    }
}

class Art(@DrawableRes val image: Int, @StringRes val title: Int, @StringRes val author: Int, @StringRes val year: Int)

@Composable
fun ArtSpacePage() {
    var currentArtNumber by remember { mutableStateOf(0) }
    val currentArt = when(currentArtNumber) {
        0 -> Art(R.drawable.lemon_tree, R.string.lemon_tree_title, R.string.lemon_tree_author, R.string.lemon_tree_year)
        1 -> Art(R.drawable.lemon_squeeze, R.string.lemon_squeeze_title, R.string.lemon_squeeze_author, R.string.lemon_squeeze_year)
        2 -> Art(R.drawable.lemon_drink, R.string.lemon_drink_title, R.string.lemon_drink_author, R.string.lemon_drink_year)
        else -> Art(R.drawable.lemon_restart, R.string.lemon_restart_title, R.string.lemon_restart_author, R.string.lemon_restart_year)
    }

    if (currentArtNumber > 3) currentArtNumber = 0
    else if (currentArtNumber < 0) currentArtNumber = 3

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            Surface(modifier = Modifier
                .shadow(10.dp)
                .border(BorderStroke(1.dp, Color.Black))
            ) {
                Image(
                    painter = painterResource(currentArt.image),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(20.dp)
                )
            }
        }
        Surface(modifier = Modifier
            .shadow(5.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .padding(20.dp)
            ) {
                Text(
                    text = stringResource(currentArt.title),
                    fontSize = 30.sp,
                    modifier = Modifier.padding(bottom = 10.dp)
                )
                Row {
                    Text(
                        text = stringResource(currentArt.author),
                        fontWeight = FontWeight.Bold,
                    )
                    Text(
                        text = stringResource(currentArt.year),
                        modifier = Modifier.padding(start = 10.dp)
                    )
                }
            }
        }
        Spacer(Modifier.height(20.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(onClick = { currentArtNumber-- }) {
                Text("Previous")
            }
            Button(onClick = { currentArtNumber++ }) {
                Text("Next")
            }
        }
        Spacer(Modifier.height(10.dp))
    }
}

@Preview(showSystemUi = true)
@Composable
fun DefaultPreview() {
    ArtSpaceTheme {
        ArtSpacePage()
    }
}