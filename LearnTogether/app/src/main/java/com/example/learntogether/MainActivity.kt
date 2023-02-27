package com.example.learntogether

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.layout.getDefaultLazyLayoutKey
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.res.TypedArrayUtils.getString
import com.example.learntogether.ui.theme.LearnTogetherTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnTogetherTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ArticlePage(
                        title = getString(R.string.article_title),
                        para1 = getString(R.string.paragraph_1),
                        para2 = getString(R.string.paragraph_2))
                }
            }
        }
    }
}

@Composable
fun ArticleTitle(title: String) {
    Text(
        text = title,
        fontSize = 24.sp,
        modifier = Modifier
            .padding(
                top = 16.dp,
                bottom = 16.dp,
                start = 16.dp,
                end = 16.dp
            )
    )
}

@Composable
fun ArticleParagraph1(paragraph: String) {
    Text(
        text = paragraph,
        textAlign = TextAlign.Justify,
        modifier = Modifier
            .padding(
                start = 16.dp,
                end = 16.dp
            )
    )
}

@Composable
fun ArticleParagraph2(paragraph: String) {
    Text(
        text = paragraph,
        textAlign = TextAlign.Justify,
        modifier = Modifier
            .padding(
                top = 16.dp,
                bottom = 16.dp,
                start = 16.dp,
                end = 16.dp
            )
    )
}

@Composable
fun ArticlePage(title: String, para1: String, para2: String) {
    val image = painterResource(R.drawable.bg_compose_background)

    Column {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
        )
        ArticleTitle(title = title)
        ArticleParagraph1(paragraph = para1)
        ArticleParagraph2(paragraph = para2)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LearnTogetherTheme {
        ArticlePage(title = "asdfads", para1 = "fdf", para2 = "vvv")
    }
}


// solution: https://github.com/google-developer-training/basic-android-kotlin-compose-training-practice-problems/tree/main/Unit%201/Pathway%203/ComposeArticle