package com.agung.uts.entity


import com.google.gson.annotations.SerializedName

data class Lokasi(
    @SerializedName("lat")
    val lat: Double,
    @SerializedName("lon")
    val lon: Double
)