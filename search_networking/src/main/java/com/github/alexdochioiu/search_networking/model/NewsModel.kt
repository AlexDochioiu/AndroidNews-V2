package com.github.alexdochioiu.search_networking.model

import com.github.alexdochioiu.androidnewsv2.model.Status
import com.squareup.moshi.Json

/**
 * Created by Alex Dochioiu on 22/03/2019
 *
 * [status] whether the request was successful
 * [totalResults] total number of articles found for the query (not necessarily the same as the number of articles in [articles].size
 * [articles] list of [ArticleModel] (for the currently requested page)
 */
data class NewsModel(
    @field:Json(name = "status") val status: Status,
    @field:Json(name = "totalResults") val totalResults: Int,
    @field:Json(name = "articles") val articles: List<ArticleModel>
)