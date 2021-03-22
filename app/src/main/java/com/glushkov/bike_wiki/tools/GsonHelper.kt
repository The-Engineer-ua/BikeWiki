package com.glushkov.bike_wiki.tools

import android.content.Context
import android.util.Log
import com.glushkov.bike_wiki.data.models.local.ManufacturerModel
import com.glushkov.bike_wiki.data.models.local.MotorcycleModel
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader

class GsonHelper(private val context: Context) {
    private val gson: Gson = GsonBuilder()
        .setPrettyPrinting()
        .create()

    private val motorcyclesToken = object : TypeToken<List<MotorcycleModel>>() {}.type
    private val manufacturersToken = object : TypeToken<List<ManufacturerModel>>() {}.type

    private fun getAssetFile(name: String) : String {
        var stream: InputStream? = null
        var reader: BufferedReader? = null
        var result = ""
        try {
            stream = context.assets.open(name)
            reader = BufferedReader(InputStreamReader(stream))
            val total: StringBuilder = StringBuilder()
            var line: String?
            while (reader.readLine().also { line = it } != null) {
                total.append(line).append('\n')
            }

            result = total.toString()
        } catch (exception: Exception) {
            Log.e(GsonHelper::class.simpleName, "Error reading asset file:$name", exception)
        } finally {
            stream?.close()
            reader?.close()
        }

        return result
    }

    fun getMotorcycles() : List<MotorcycleModel> {
        val json = getAssetFile("motorcycles.json")
        return gson.fromJson(json, motorcyclesToken)
    }

    fun getManufacturers(): List<ManufacturerModel> {
        val json = getAssetFile("manufacturers.json")
        return gson.fromJson(json, manufacturersToken)
    }

    fun getMotorcycles(data: String) : List<MotorcycleModel> {
        return gson.fromJson(data, motorcyclesToken)
    }

    fun getManufacturers(data: String): List<ManufacturerModel> {
        return gson.fromJson(data, manufacturersToken)
    }
}