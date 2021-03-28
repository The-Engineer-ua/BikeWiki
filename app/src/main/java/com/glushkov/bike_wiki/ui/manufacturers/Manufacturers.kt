package com.glushkov.bike_wiki.ui.manufacturers

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.lifecycle.viewmodel.compose.viewModel
import com.glushkov.bike_wiki.data.models.local.ManufacturerModel


@Composable
fun Manufacturers() {
    val vm : ManufacturersViewModel = viewModel()
    vm.getManufacturers()
    val data: List<ManufacturerModel> by vm.manufacturersLiveData.observeAsState(listOf())

    Row(modifier = Modifier.fillMaxSize()) {
        Text(textAlign = TextAlign.Center, text = "Size of manufacturers collection is: ${data.size}")
    }
}