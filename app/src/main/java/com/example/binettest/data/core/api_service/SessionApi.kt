package com.example.binettest.data.core.api_service

import com.example.binettest.data.entry_list.models.EntryDataListModel
import com.example.binettest.data.core.models.UserSessionDataModel
import com.example.binettest.data.entry_list.api_service.RetrofitInstance
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface SessionApi {

    @FormUrlEncoded
    @POST("testAPI/")
    fun getSession(
            @Field("a") a: String
    ): Call<UserSessionDataModel?>?
}
