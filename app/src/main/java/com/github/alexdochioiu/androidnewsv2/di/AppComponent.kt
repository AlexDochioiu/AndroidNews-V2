package com.github.alexdochioiu.androidnewsv2.di

import android.app.Application
import android.content.Context
import com.github.alexdochioiu.androidnewsv2.NewsApplication
import com.github.alexdochioiu.androidnewsv2.networking.ConvertorsModule
import com.github.alexdochioiu.androidnewsv2.networking.NetworkingModule
import com.github.alexdochioiu.androidnewsv2.networking.RetrofitFactory
import com.squareup.moshi.Moshi
import dagger.BindsInstance
import dagger.Component
import okhttp3.OkHttpClient
import retrofit2.CallAdapter
import retrofit2.Converter

@AppScope
@Component(modules = [AppModule::class, NetworkingModule::class, ConvertorsModule::class])
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

    //region Converters
    fun moshi(): Moshi

    fun callAdapterFactory(): CallAdapter.Factory

    fun converterFactory(): Converter.Factory
    //endregion
}