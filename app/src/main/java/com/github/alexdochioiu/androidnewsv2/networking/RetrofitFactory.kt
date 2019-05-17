package com.github.alexdochioiu.androidnewsv2.networking

import com.github.alexdochioiu.androidnewsv2.di.AppScope
import okhttp3.OkHttpClient
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import javax.inject.Inject

/**
 * Created by Alex Dochioiu on 2019-05-17
 */
@AppScope
class RetrofitFactory @Inject internal constructor(private val okHttpClient: OkHttpClient) {

    fun makeInstance(
        baseUrl: String,
        converterFactory: Converter.Factory,
        callAdapterFactory: CallAdapter.Factory
    ): Retrofit =
        Retrofit
            .Builder()
            .client(okHttpClient)
            .addConverterFactory(converterFactory)
            .addCallAdapterFactory(callAdapterFactory)
            .baseUrl(baseUrl)
            .build()
}