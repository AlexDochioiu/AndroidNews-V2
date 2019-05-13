package com.github.alexdochioiu.androidnewsv2.di

import com.github.alexdochioiu.androidnewsv2.NewsApplication
import com.github.alexdochioiu.core.di.AppScope
import com.github.alexdochioiu.core.di.CoreComponent
import com.github.alexdochioiu.core.di.InjectableComponent
import dagger.BindsInstance
import dagger.Component

@AppScope
@Component(dependencies = [CoreComponent::class], modules = [AppModule::class])
interface AppComponent : InjectableComponent<NewsApplication> {

    @Component.Factory
    interface Factory {
        fun create(
            coreComponent: CoreComponent,
            @BindsInstance application: NewsApplication
        ): AppComponent
    }
}