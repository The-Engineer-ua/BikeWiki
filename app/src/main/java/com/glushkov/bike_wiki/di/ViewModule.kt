package com.glushkov.bike_wiki.di

import com.glushkov.bike_wiki.ui.manufacturers.ManufacturersViewModel
import com.glushkov.bike_wiki.ui.motorcycle_info.MotorcycleInfoViewModel
import com.glushkov.bike_wiki.ui.motorcycles.MotorcyclesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModule = module {
    viewModel {
        MotorcycleInfoViewModel(get())
    }
    viewModel {
        MotorcyclesViewModel(get())
    }
    viewModel {
        ManufacturersViewModel(get())
    }
}