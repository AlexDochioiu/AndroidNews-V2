package com.github.alexdochioiu.search_networking.di

import android.app.Application
import android.content.Context
import com.github.alexdochioiu.androidnewsv2.NewsApplication
import com.github.alexdochioiu.androidnewsv2.di.AppComponent
import com.github.alexdochioiu.androidnewsv2.di.AppContext
import com.github.alexdochioiu.androidnewsv2.di.Feature_NetworkingPersistenceScope
import com.github.alexdochioiu.search_networking.NewsRepository
import dagger.Component

/**
 * Created by Alex Dochioiu on 2019-05-15
 */
@Component(dependencies = [AppComponent::class], modules = [SearchNetworkModule::class])
@Feature_NetworkingPersistenceScope
interface SearchNetworkComponent {

    //region Context
    fun newsApplication(): NewsApplication

    fun application(): Application

    @AppContext
    fun appContext(): Context
    //endregion

    //region Repositories todo move to new dynamic module
    fun newsRepo(): NewsRepository
    //endregion

}