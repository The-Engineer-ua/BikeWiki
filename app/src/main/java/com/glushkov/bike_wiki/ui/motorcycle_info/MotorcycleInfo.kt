package com.glushkov.bike_wiki.ui.motorcycle_info

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.glushkov.bike_wiki.data.models.local.MotorcycleModel
import kotlinx.coroutines.InternalCoroutinesApi


@InternalCoroutinesApi
@ExperimentalFoundationApi
@Composable
fun MotorcycleInfo(navController : NavHostController, id: Int) {
    val vm : MotorcycleInfoViewModel = viewModel()
    vm.getMotorcycleById(id)
    val data: MotorcycleModel? by vm.motorcycleLiveData.observeAsState()


}

@InternalCoroutinesApi
@ExperimentalFoundationApi
@Preview
@Composable
fun PreviewMotorcycles() {
    MotorcycleInfo(rememberNavController(), 1)
}