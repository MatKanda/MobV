package com.example.myapp.network

import com.example.myapp.database.PubTable
import com.example.myapp.process_json.PubParent
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface PubsApi {

    @Headers("api-key: KHUu1Fo8042UwzczKz9nNeuVOsg2T4ClIfhndD2Su0G0LHHCBf0LnUF05L231J0M")
    @POST("find")
    suspend fun getAllPubs(@Body postBody: PostBody) : Response<PubParent>
}

