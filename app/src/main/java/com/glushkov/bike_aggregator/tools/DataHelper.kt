package com.glushkov.bike_aggregator.tools

import com.glushkov.bike_aggregator.data.models.ManufacturerModel
import com.glushkov.bike_aggregator.data.models.MotorcycleModel
import com.glushkov.bike_aggregator.data.models.enums.MotorcycleType
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class DataHelper(private val gsonHelper: GsonHelper) {
    var isReady: Boolean = false
        private set

    var manufacturersData: List<ManufacturerModel> = listOf()
        private set
    var motorcyclesData: List<MotorcycleModel> = listOf()
        private set

    fun init() {
        loadManufacturers()
        loadMotorcycles()
    }

    private fun loadManufacturers() {
        runBlocking {
            coroutineScope { // Creates a coroutine scope
                launch {
                    manufacturersData = gsonHelper.getManufacturers()
                    checkDataStatus()
                }
            }
        }
    }

    private fun loadMotorcycles() {
        runBlocking {
            coroutineScope { // Creates a coroutine scope
                launch {
                    motorcyclesData = gsonHelper.getMotorcycles()
                    checkDataStatus()
                }
            }
        }
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
        if (motorcyclesData.isNotEmpty() && manufacturersData.isNotEmpty())
            isReady = true
    }

    fun getMotorcyclesByType(type: MotorcycleType): List<MotorcycleModel>? {
        return motorcyclesData.filter { it.type == type.name }
    }
}