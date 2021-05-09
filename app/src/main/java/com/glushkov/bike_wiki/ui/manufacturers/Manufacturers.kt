package com.glushkov.bike_wiki.ui.manufacturers

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.glushkov.bike_wiki.data.models.ui.CardViewModel
import com.glushkov.bike_wiki.ui.tools.GridView
import kotlinx.coroutines.InternalCoroutinesApi


@InternalCoroutinesApi
@ExperimentalFoundationApi
@Composable
fun Manufacturers(navController : NavHostController) {
    val vm : ManufacturersViewModel = viewModel()
    vm.getManufacturers()
    val data: List<CardViewModel> by vm.manufacturersLiveData.observeAsState(listOf())

    GridView(data = data) {
        navController.navigate("motorcycles/$it")
    }
}

@InternalCoroutinesApi
@ExperimentalFoundationApi
@Preview
@Composable
fun PreviewManufacturers() {
    Manufacturers(rememberNavController())
}