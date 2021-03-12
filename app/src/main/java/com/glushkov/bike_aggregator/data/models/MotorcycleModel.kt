package com.glushkov.bike_aggregator.data.models

import com.google.gson.annotations.SerializedName

data class MotorcycleModel(
    val id: Int,
    val name: String,
    val type: String,
    val description: String,
    @SerializedName("max_speed")
    val maxSpeed: String,
    @SerializedName("zero_hundred")
    val zeroHundred: String,
    //Link to Manufacturers collection
    @SerializedName("manufacturer_id")
    val manufacturerId: Int,
    @SerializedName("short_description")
    val shortDescription: String,
    @SerializedName("icon_resource_name")
    val iconResourceName: String?,
    @SerializedName("subjective_stats")
    val subjectiveStatsModel: SubjectiveStatsModel?,

    @SerializedName("raw_tech_info")
    val techInfo: String?,

    val price: String
)