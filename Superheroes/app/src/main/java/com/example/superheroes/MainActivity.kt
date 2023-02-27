package com.example.superheroes

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superheroes.data.Datasource
import com.example.superheroes.model.Superhero
import com.example.superheroes.ui.theme.SuperheroesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SuperheroesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                     SuperheroesApp()
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SuperheroesApp() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            SuperheroAppBar()
        }
    ) {
        SuperheroList(modifier = Modifier.background(MaterialTheme.colors.background))
    }
}

@Composable
fun SuperheroAppBar() {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
    ) {
        Text(
            text = "Superheroes",
            style = MaterialTheme.typography.h1,
        )
    }
}

@Composable
fun SuperheroList(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier
            .padding(16.dp)
    ) {
        items(Datasource.Superheroes) { superhero ->
            SuperheroCard(superhero)
            Spacer(modifier = Modifier.size(8.dp))
        }
    }
}

@Composable
fun SuperheroCard(
    superhero: Superhero,
    modifier: Modifier = Modifier
) {
    Card(
        elevation = 2.dp,
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
            ) {
                Text(
                    text = stringResource(superhero.name),
                    style = MaterialTheme.typography.h3
                )
                Text(
                    text = stringResource(superhero.description),
                    style = MaterialTheme.typography.body1
                )
            }
            Spacer(Modifier.width(16.dp))
            Image(
                painter = painterResource(superhero.image),
                contentDescription = null,
                modifier = Modifier
                    .height(72.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SuperheroAppPreview() {
    SuperheroesTheme(darkTheme = false) {
        SuperheroesApp()
    }
}

@Preview(showBackground = true)
@Composable
fun SuperheroAppDarkThemePreview() {
    SuperheroesTheme(darkTheme = true) {
        SuperheroesApp()
    }
}