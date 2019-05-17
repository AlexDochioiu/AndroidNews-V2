package com.github.alexdochioiu.search_networking.di

import com.github.alexdochioiu.androidnewsv2.di.AppComponent
import com.github.alexdochioiu.androidnewsv2.di.Feature_NetworkingPersistenceScope
import dagger.Component

/**
 * Created by Alex Dochioiu on 2019-05-15
 */
@Component(dependencies = [AppComponent::class])
@Feature_NetworkingPersistenceScope
interface SearchNetworkingComponent {
}