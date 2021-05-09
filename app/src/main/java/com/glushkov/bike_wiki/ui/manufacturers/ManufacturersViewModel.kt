package com.glushkov.bike_wiki.ui.manufacturers

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.glushkov.bike_wiki.data.models.ui.CardViewModel
import com.glushkov.bike_wiki.tools.ViewDataHelper
import com.glushkov.bike_wiki.ui.MainApplication
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.collect

class ManufacturersViewModel : ViewModel() {

    private val dataSource = MainApplication.instance?.localData

    private val _manufacturersLiveData: MutableLiveData<List<CardViewModel>> = MutableLiveData()
    val manufacturersLiveData: LiveData<List<CardViewModel>>
        get() {
            return _manufacturersLiveData
        }

    @InternalCoroutinesApi
    fun getManufacturers() {
        dataSource?.let { source ->
            viewModelScope.launch {
                source.manufacturersData.collect { list ->
                    _manufacturersLiveData.postValue(list.map { ViewDataHelper.manufacturerToCardViewModel(it) })
                }
            }
        }
    }
}