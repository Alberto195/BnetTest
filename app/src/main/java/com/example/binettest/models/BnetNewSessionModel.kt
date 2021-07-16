package com.example.binettest.models

import com.google.gson.annotations.SerializedName

data class BnetNewSessionModel(
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("status")
    val status: Int
) {
    data class Data(
        @SerializedName("session")
        val session: String
    )
}