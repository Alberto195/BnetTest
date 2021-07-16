package com.example.binettest.repository.api

import com.example.binettest.models.AddEntryModel
import com.example.binettest.models.BnetNewSessionModel
import com.example.binettest.models.GetEntriesModel
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface BnetApi {

    @FormUrlEncoded
    @POST("testAPI/")
    fun getSession(
        @Field("a") a: String
    ): Call<BnetNewSessionModel>

    @FormUrlEncoded
    @POST("testAPI/")
    fun getEntries(
        @Field("a") a: String,
        @Field("session") session: String
    ): Call<GetEntriesModel>

    @FormUrlEncoded
    @POST("testAPI/")
    fun addEntry(
        @Field("a") a: String,
        @Field("session") session: String,
        @Field("body") body: String
    ): Call<AddEntryModel>

    companion object {
        operator fun invoke(): BnetApi? {
            return RetrofitInstance.retrofitInstance
        }
    }
}
