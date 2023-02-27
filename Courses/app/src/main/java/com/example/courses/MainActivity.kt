package com.example.courses

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.courses.model.Topic
import com.example.courses.ui.theme.CoursesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoursesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    TopicScreen(DataSource.topics)
                }
            }
        }
    }
}

@Composable
fun TopicScreen(
    topicList: List<Topic>,
    modifier: Modifier = Modifier
) {
    val topicListGrouped = topicList.withIndex().groupBy(
        keySelector = { it.index % 2 },
        valueTransform = { it.value }
    )
    val topicListLeft = topicListGrouped[0]
    val topicListRight = topicListGrouped[1]

    Row(
        modifier = modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        TopicCardColumn(topicListLeft, Modifier.weight(0.5f))
        Spacer(modifier = Modifier.width(8.dp))
        TopicCardColumn(topicListRight, Modifier.weight(0.5f))
    }
}

@Composable
fun TopicCardColumn(
    topicList: List<Topic>?,
    modifier: Modifier = Modifier
) {
    if (topicList != null) {
        LazyColumn (modifier = modifier) {
            items(topicList) { topic ->
                TopicCard(topic, Modifier.fillMaxWidth())
            }
        }
    }
}

@Composable
fun TopicCard(
    topic: Topic,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier.padding(bottom = 8.dp),
        elevation = 4.dp
    ) {
        Row(
            modifier = Modifier,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(topic.imageId),
                contentDescription = null,
                modifier = Modifier.size(68.dp)
            )
            Column(
                modifier = Modifier
                    .padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 8.dp),
            ) {
                Text(
                    text = stringResource(topic.topicId),
                    fontSize = 15.sp,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Row(
                    modifier = Modifier,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_number),
                        contentDescription = null,
                        modifier = Modifier.size(12.dp)
                    )
                    Text(
                        text = topic.numberOfCourses.toString(),
                        fontSize = 12.sp,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun DefaultPreview() {
    CoursesTheme {
        TopicScreen(DataSource.topics)
    }
}