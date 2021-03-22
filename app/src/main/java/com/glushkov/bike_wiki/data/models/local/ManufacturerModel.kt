package com.glushkov.bike_wiki.data.models.local

import com.google.gson.annotations.SerializedName

data class ManufacturerModel (
    val id: Int,
    val name: String,
    @SerializedName("short_description")
    val shortDescription: String,
    val description: String,

    @SerializedName("icon_resource_name")
    val iconResourceName: String?)