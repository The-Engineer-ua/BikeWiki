package com.glushkov.bike_wiki.data

import com.glushkov.bike_wiki.data.models.local.ManufacturerModel
import com.glushkov.bike_wiki.data.models.local.MotorcycleModel
import com.glushkov.bike_wiki.data.models.enums.MotorcycleType
import com.glushkov.bike_wiki.tools.GsonHelper
import kotlinx.coroutines.*

class AppLocalRepository(private val gsonHelper: GsonHelper) {
    private var isReady: Boolean = false

    private var _manufacturersData: List<ManufacturerModel> = listOf()
    var manufacturersData: List<ManufacturerModel> = listOf()
        private set
        get() {
            return if (!isReady) {
                emptyList()
            } else
                _manufacturersData
        }

    private var _motorcyclesData: List<MotorcycleModel> = listOf()
    private var motorcyclesData: List<MotorcycleModel> = listOf()
        get() {
            return if (!isReady) {
                emptyList()
            } else
                _motorcyclesData
        }

    fun init(scope: CoroutineScope) {
        scope.launch (Dispatchers.IO) {
            loadManufacturers()
        }
        scope.launch (Dispatchers.IO) {
            loadMotorcycles()
        }
    }

    private fun loadManufacturers() {
        _manufacturersData = gsonHelper.getManufacturers()
        checkDataStatus()
    }

    private fun loadMotorcycles() {
        _motorcyclesData = gsonHelper.getMotorcycles()
        checkDataStatus()
    }

    fun getMotorcycles() : List<MotorcycleModel> {
        return emptyList()
    }

    fun getMotorcyclesByManufacturerId(id: Int) : List<MotorcycleModel> {
        return motorcyclesData.filter { it.manufacturerId == id }
    }

    fun getManufacturerById(id: Int) : ManufacturerModel? {
        return manufacturersData.filter { it.id == id }.getOrNull(0)
    }

    fun getMotorcycleById(id: Int) : MotorcycleModel? {
        return motorcyclesData.filter { it.id == id }.getOrNull(0)
    }

    private fun checkDataStatus() {
        if (_motorcyclesData.isNotEmpty() && _manufacturersData.isNotEmpty())
            isReady = true
    }

    fun getMotorcyclesByType(type: MotorcycleType): List<MotorcycleModel>? {
        return motorcyclesData.filter { it.type == type.name }
    }
}