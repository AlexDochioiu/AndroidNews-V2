package com.github.alexdochioiu.androidnewsv2

import android.app.Activity
import android.app.Application
import android.content.Context
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.os.BuildCompat
import com.github.alexdochioiu.androidnewsv2.NewsApplication.Companion.appComponent
import com.github.alexdochioiu.androidnewsv2.di.AppComponent
import com.github.alexdochioiu.androidnewsv2.di.DaggerAppComponent
import com.github.alexdochioiu.core.di.CoreComponent
import com.github.alexdochioiu.core.di.DaggerCoreComponent

class NewsApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        val nightMode = if (BuildCompat.isAtLeastQ()) {
            AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM
        } else {
            AppCompatDelegate.MODE_NIGHT_AUTO_BATTERY
        }
        AppCompatDelegate.setDefaultNightMode(nightMode)
    }

    private val coreComponent: CoreComponent by lazy {
        DaggerCoreComponent.create()
    }

    private val appComponent: AppComponent by lazy {
        DaggerAppComponent
            .factory()
            .create(coreComponent, this)
    }

    companion object {
        @JvmStatic
        fun appComponent(context: Context) =
            (context.applicationContext as NewsApplication).appComponent
    }
}
fun Activity.appComponent() = appComponent(this)
