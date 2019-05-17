package com.github.alexdochioiu.androidnewsv2.di

import android.app.Application
import android.content.Context
import com.github.alexdochioiu.androidnewsv2.NewsApplication
import dagger.Binds
import dagger.Module

@Module
interface AppModule {

    @Binds
    fun application(newsApplication: NewsApplication): Application

    @Binds
    @AppContext
    fun context(newsApplication: NewsApplication): Context
}