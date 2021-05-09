package com.glushkov.bike_wiki.data

import com.glushkov.bike_wiki.data.models.local.ManufacturerModel
import com.glushkov.bike_wiki.data.models.local.MotorcycleModel
import com.glushkov.bike_wiki.tools.GsonHelper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

class AppLocalRepository(private val gsonHelper: GsonHelper) {

    var manufacturersData: Flow<List<ManufacturerModel>> = flow {
        emit(loadManufacturers())
    }
        private set

    var motorcyclesData: Flow<List<MotorcycleModel>> = flow {
        emit(loadMotorcycles())
    }
        private set

    private fun loadManufacturers() : List<ManufacturerModel> {
        return gsonHelper.getManufacturers()
    }

    private fun loadMotorcycles() : List<MotorcycleModel> {
        return gsonHelper.getMotorcycles()
    }

    fun getMotorcyclesByManufacturerId(id: Int) : Flow<List<MotorcycleModel>> {
        return motorcyclesData.map { flow ->
            flow.filter { item ->
                item.manufacturerId == id
            }
        }
    }
// TODO - show info of manufacturer
//    fun getManufacturerById(id: Int) : ManufacturerModel? {
//        return manufacturersData.filter { it.id == id }.getOrNull(0)
//    }
//
    fun getMotorcycleById(id: Int) : Flow<MotorcycleModel?> {
        return motorcyclesData.map {  flow -> flow.filter { it.id == id }.getOrNull(0) }
    }
}