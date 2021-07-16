package com.example.binettest.models


import com.google.gson.annotations.SerializedName


data class AddEntryModel(
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("status")
    val status: Int
) {
    data class Data(
        @SerializedName("id")
        val id: String
    )
}