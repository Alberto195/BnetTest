package com.example.binettest.data.entry_list.api_service

import com.example.binettest.data.entry_list.models.EntryDataListModel
import io.reactivex.rxjava3.core.Single
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface BnetApi {

    @FormUrlEncoded
    @POST("testAPI/")
    fun getEntries(
            @Field("a") a: String?,
            @Field("session") session: String?
    ): Single<EntryDataListModel?>

    companion object {
        operator fun invoke(): BnetApi? {
            return RetrofitInstance.retrofitInstance
        }
    }
}
