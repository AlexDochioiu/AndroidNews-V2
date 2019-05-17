package com.github.alexdochioiu.androidnewsv2.networking

import android.content.Context
import android.util.Log
import com.github.alexdochioiu.androidnewsv2.di.AppContext
import com.github.alexdochioiu.androidnewsv2.di.AppScope
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.io.File

/**
 * Created by Alex Dochioiu on 2019-05-17
 */
@Module
internal class NetworkingModule {

    @Provides
    @AppScope
    internal fun loggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor { message -> Log.v("okhttp3", message) }
            .apply { level = HttpLoggingInterceptor.Level.BASIC }

    @Provides
    @AppScope
    internal fun cache(cacheFile: File): Cache = Cache(cacheFile, 10 * 1000 * 1000) //10MB Cache

    @Provides
    @AppScope
    internal fun cacheFile(@AppContext context: Context): File = File(context.cacheDir, "okhttp_cache")

    @Provides
    @AppScope
    internal fun okHttpClient(
        loggingInterceptor: HttpLoggingInterceptor,
        cache: Cache
    ): OkHttpClient =
        OkHttpClient
            .Builder()
            .addInterceptor(loggingInterceptor)
            .cache(cache)
            .build()


}