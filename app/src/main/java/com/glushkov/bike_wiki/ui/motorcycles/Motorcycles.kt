package com.glushkov.bike_wiki.ui.motorcycles

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.glushkov.bike_wiki.data.models.ui.CardViewModel
import com.glushkov.bike_wiki.ui.tools.GridView
import kotlinx.coroutines.InternalCoroutinesApi
import org.koin.androidx.compose.getViewModel


@InternalCoroutinesApi
@ExperimentalFoundationApi
@Composable
fun Motorcycles(navController : NavHostController, id: Int) {
    val vm : MotorcyclesViewModel = getViewModel()
    vm.getMotorcyclesByManufacturerId(id)
    val data: List<CardViewModel> by vm.motorcyclesLiveData.observeAsState(listOf())

    GridView(data = data) {
        navController.navigate("motorcycleInfo/${it}")
    }
}

@InternalCoroutinesApi
@ExperimentalFoundationApi
@Preview
@Composable
fun PreviewMotorcycles() {
    Motorcycles(rememberNavController(), 1)
}