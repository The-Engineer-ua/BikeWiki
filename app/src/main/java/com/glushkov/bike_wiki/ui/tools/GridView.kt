package com.glushkov.bike_wiki.ui.tools

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import com.glushkov.bike_wiki.data.models.ui.CardViewModel

/**
 * Grid view for list of card views
 * @param data list of [CardViewModel]
 */
@ExperimentalFoundationApi
@Composable
fun GridView (data: List<CardViewModel>, onClick : (Int) -> Unit) {
    LazyVerticalGrid(cells = GridCells.Fixed(2)) {
        items(data.size) { index ->
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                CardView(data = data[index], onClick = {id -> onClick(id)})
            }
        }
    }
}

/**
 * Preview view for grid composable
 */
@ExperimentalFoundationApi
@Preview
@Composable
fun PreviewGridView() {
    GridView(data = listOf(
        CardViewModel(1, "Title 1", "ic_kawasaki", "Decsc 1"),
        CardViewModel(2, "Title 2", "ic_ktm", "Decsc 2"),
        CardViewModel(3, "Title 3", "ic_ducati", "Decsc 3"),
        CardViewModel(4, "Title 4", "ic_yamaha", "Decsc 4"),
        CardViewModel(5, "Title 5", "ic_suzuki", "Decsc 5"))
    ) {}
}