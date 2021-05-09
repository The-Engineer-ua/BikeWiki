package com.glushkov.bike_wiki.ui.motorcycles

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.glushkov.bike_wiki.data.models.ui.CardViewModel
import com.glushkov.bike_wiki.tools.ViewDataHelper
import com.glushkov.bike_wiki.ui.MainApplication
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MotorcyclesViewModel : ViewModel() {
    private val dataSource = MainApplication.instance?.localData

    private val _motorcyclesLiveData: MutableLiveData<List<CardViewModel>> = MutableLiveData()
    val motorcyclesLiveData: LiveData<List<CardViewModel>>
        get() {
            return _motorcyclesLiveData
        }

    @InternalCoroutinesApi
    fun getMotorcyclesByManufacturerId(id: Int) {
        dataSource?.let { source ->
            viewModelScope.launch {
                source.getMotorcyclesByManufacturerId(id).collect { list ->
                    _motorcyclesLiveData.postValue(list.map { ViewDataHelper.motorcycleToCardViewModel(it) })
                }
            }
        }
    }
}