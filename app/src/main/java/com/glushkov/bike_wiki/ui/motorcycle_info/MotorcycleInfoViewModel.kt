package com.glushkov.bike_wiki.ui.motorcycle_info

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.glushkov.bike_wiki.data.models.local.MotorcycleModel
import com.glushkov.bike_wiki.ui.MainApplication
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MotorcycleInfoViewModel : ViewModel() {
    private val dataSource = MainApplication.instance?.localData

    private val _motorcycleLiveData: MutableLiveData<MotorcycleModel> = MutableLiveData()
    val motorcycleLiveData: LiveData<MotorcycleModel>
        get() {
            return _motorcycleLiveData
        }

    @InternalCoroutinesApi
    fun getMotorcycleById(id: Int) {
        dataSource?.let { source ->
            viewModelScope.launch {
                source.getMotorcycleById(id).collect { item ->
                    item?.let { _motorcycleLiveData.postValue(it) }
                }
            }
        }
    }
}