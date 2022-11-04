package com.agung.uts.entity


import com.google.gson.annotations.SerializedName

data class Hospital(
    @SerializedName("alamat")
    val alamat: String,
    @SerializedName("kode_rs")
    val kodeRs: String,
    @SerializedName("lokasi")
    val lokasi: Lokasi,
    @SerializedName("nama")
    val nama: String,
    @SerializedName("telepon")
    val telepon: String,
    @SerializedName("tempat_tidur")
    val tempatTidur: Int,
    @SerializedName("tipe")
    val tipe: String,
    @SerializedName("wilayah")
    val wilayah: String
)