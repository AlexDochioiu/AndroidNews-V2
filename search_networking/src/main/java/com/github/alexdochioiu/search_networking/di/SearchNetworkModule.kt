package com.github.alexdochioiu.search_networking.di

import com.github.alexdochioiu.androidnewsv2.di.Feature_NetworkingPersistenceScope
import com.github.alexdochioiu.androidnewsv2.networking.RetrofitFactory
import com.github.alexdochioiu.search_networking.baseNewsApiUrl
import com.github.alexdochioiu.search_networking.retrofit.SearchService
import dagger.Module
import dagger.Provides
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit

/**
 * Created by Alex Dochioiu on 2019-05-17
 */
@Module
internal class SearchNetworkModule {
    @Provides
    @Feature_NetworkingPersistenceScope
    internal fun searchService(retrofit: Retrofit): SearchService = retrofit.create(SearchService::class.java)

    @Provides
    @Feature_NetworkingPersistenceScope
    internal fun retrofit(
        retrofitFactory: RetrofitFactory,
        converterFactory: Converter.Factory,
        callAdapterFactory: CallAdapter.Factory
    ): Retrofit = retrofitFactory.makeInstance(baseNewsApiUrl, converterFactory, callAdapterFactory)
}