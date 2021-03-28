package com.glushkov.bike_wiki.ui.manufacturers

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.glushkov.bike_wiki.data.models.local.ManufacturerModel
import com.glushkov.bike_wiki.ui.MainApplication
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ManufacturersViewModel : ViewModel() {

    private val dataSource = MainApplication.instance?.localData

    private val _manufacturersLiveData: MutableLiveData<List<ManufacturerModel>> = MutableLiveData()
    val manufacturersLiveData: LiveData<List<ManufacturerModel>>
        get() {
            return _manufacturersLiveData
        }

    fun getManufacturers() {
        dataSource?.let {
            val gatheredData = it.manufacturersData
            if (gatheredData.isEmpty()) {
                viewModelScope.launch (Dispatchers.Default) {
                    delay(100)
                    getManufacturers()
                }
            }
            else {
                _manufacturersLiveData.postValue(gatheredData)
            }
        }
    }
}