package com.github.alexdochioiu.androidnewsv2.networking

import com.github.alexdochioiu.androidnewsv2.di.AppScope
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Created by Alex Dochioiu on 2019-05-17
 */
@Module
internal class ConvertorsModule {
    @Provides
    @AppScope
    internal fun converterFactory(moshi: Moshi): Converter.Factory = MoshiConverterFactory.create(moshi)

    @Provides
    @AppScope
    internal fun callAdapterFactory(): CallAdapter.Factory = CoroutineCallAdapterFactory()

    @Provides
    @AppScope
    internal fun moshi(): Moshi = Moshi.Builder().build()
}