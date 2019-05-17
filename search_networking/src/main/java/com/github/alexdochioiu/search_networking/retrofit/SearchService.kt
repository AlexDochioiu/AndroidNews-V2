package com.github.alexdochioiu.search_networking.retrofit

import com.github.alexdochioiu.search_networking.model.NewsModel
import com.github.alexdochioiu.search_networking.newsApiKey
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query


/**
 * Created by Alex Dochioiu on 22/03/2019
 */
internal interface SearchService {

    @GET("everything")
    fun fetchArticlesAsync(
        @Query("apiKey") apiKey: String = newsApiKey,
        @Query("q") query: String? = null, //url encoded query string
        @Query("sources") sources: String? = null, //comma-seperated string of identifiers (maximum 20)
        @Query("domains") domains: String? = null, //A comma-seperated string of domains (eg bbc.co.uk, techcrunch.com)
        @Query("excludeDomains") excludeDomains: String? = null, //A comma-seperated string of domains
        @Query("from") from: String? = null, // This should be in ISO 8601 format (e.g. 2019-03-22 or 2019-03-22T13:25:00)
        @Query("to") to: String? = null, // This should be in ISO 8601 format (e.g. 2019-03-22 or 2019-03-22T13:25:00)
        @Query("language") language: String? = null, // The 2-letter ISO-639-1 code of the language you want to get headlines for. Possible options: ar de en es fr he it nl no pt ru se ud zh . Default: all languages returned
        @Query("sortBy") sortBy: String? = null, //relevancy(based on query), popularity, publishedAt. defaults to publishedAt
        @Query("pageSize") pageSize: Int? = null, //defaults to 20; max is 100
        @Query("page") page: Int? = null // defaults to TODO 0? or 1?
    ): Deferred<NewsModel>
}