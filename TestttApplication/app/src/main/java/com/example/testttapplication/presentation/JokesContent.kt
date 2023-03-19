package com.example.testttapplication.presentation


import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.testttapplication.data.model.JokeResponse
import androidx.compose.material.Text
import androidx.compose.ui.graphics.Color

/*
* composable view of the list
* */
@Composable
fun JokesContent(
    padding: PaddingValues,
    jokes: MutableList<JokeResponse> = mutableListOf(),
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(items = jokes) {
            Text(it.joke, color = Color.Black, modifier = Modifier.padding(padding))
        }
    }
}


