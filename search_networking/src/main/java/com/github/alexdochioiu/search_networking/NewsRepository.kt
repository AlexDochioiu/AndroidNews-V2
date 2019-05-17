package com.github.alexdochioiu.search_networking

import com.github.alexdochioiu.androidnewsv2.di.Feature_NetworkingPersistenceScope
import com.github.alexdochioiu.search_networking.model.NewsModel
import com.github.alexdochioiu.search_networking.retrofit.SearchService
import kotlinx.coroutines.Deferred
import javax.inject.Inject

/**
 * Created by Alex Dochioiu on 22/03/2019
 */
@Feature_NetworkingPersistenceScope
class NewsRepository @Inject internal constructor(private val searchService: SearchService) {

    fun fetchNewsAsync(
        query: String? = null
    ) : Deferred<NewsModel> = searchService.fetchArticlesAsync(query = query)
}