package com.github.alexdochioiu.androidnewsv2.di

import android.app.Application
import android.content.Context
import com.github.alexdochioiu.androidnewsv2.NewsApplication
import com.github.alexdochioiu.androidnewsv2.networking.NetworkingModule
import com.github.alexdochioiu.androidnewsv2.networking.RetrofitFactory
import dagger.BindsInstance
import dagger.Component
import okhttp3.OkHttpClient

@AppScope
@Component(modules = [AppModule::class, NetworkingModule::class])
interface AppComponent : InjectableComponent<NewsApplication> {

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance application: NewsApplication
        ): AppComponent
    }

    //region Context
    fun newsApplication(): NewsApplication

    fun application(): Application

    @AppContext
    fun appContext(): Context
    //endregion


    //region Networking
    fun okHttpClient(): OkHttpClient

    fun retrofitFactory(): RetrofitFactory
    //endregion
}