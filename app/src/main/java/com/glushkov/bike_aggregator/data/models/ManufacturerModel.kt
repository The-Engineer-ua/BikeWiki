package com.glushkov.bike_aggregator.data.models

import com.google.gson.annotations.SerializedName

data class ManufacturerModel (
    val id: Int,
    val name: String,
    @SerializedName("short_description")
    val shortDescription: String,
    val description: String,

    @SerializedName("icon_resource_name")
    val iconResourceName: String?)