package com.glushkov.bike_wiki.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.glushkov.bike_wiki.ui.MainApplication
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    fun initRepositories() {
        MainApplication.instance?.localData?.init(viewModelScope)
    }
}