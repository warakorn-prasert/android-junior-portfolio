package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeQuadrantTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    FourQuadrantsPage(
                        title1 = stringResource(R.string.q1_title),
                        para1 = stringResource(R.string.q1_paragraph),
                        title2 = stringResource(R.string.q2_title),
                        para2 = stringResource(R.string.q2_paragraph),
                        title3 = stringResource(R.string.q3_title),
                        para3 = stringResource(R.string.q3_paragraph),
                        title4 = stringResource(R.string.q4_title),
                        para4 = stringResource(R.string.q4_paragraph)
                    )
                }
            }
        }
    }
}

@Composable
fun QuadrantContent(title: String, paragraph: String, bg_color: Long) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(Color(bg_color))
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(16.dp)
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = paragraph,
            textAlign = TextAlign.Justify
        )
    }
}

@Composable
fun FourQuadrantsPage(
    title1: String, para1: String,
    title2: String, para2: String,
    title3: String, para3: String,
    title4: String, para4: String,
) {
    Column {
        Row(modifier = Modifier.weight(0.5f)) {
            Column(modifier = Modifier.weight(0.5f)) {
                QuadrantContent(title1, para1, 0xff91a4fc)
            }
            Column(modifier = Modifier.weight(0.5f)) {
                QuadrantContent(title2, para2, 0xffff0000)
            }
        }
        Row(modifier = Modifier.weight(0.5f)) {
            Column(modifier = Modifier.weight(0.5f)) {
                QuadrantContent(title3, para3, 0xffffeb46)
            }
            Column(modifier = Modifier.weight(0.5f)) {
                QuadrantContent(title4, para4, 0xff03DAC5)
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun DefaultPreview() {
    ComposeQuadrantTheme {
        FourQuadrantsPage("a", "b", "c", "d", "e", "f", "g", "h")
    }
}


// solution: https://github.com/google-developer-training/basic-android-kotlin-compose-training-practice-problems/tree/main/Unit%201/Pathway%203/ComposeQuadrant