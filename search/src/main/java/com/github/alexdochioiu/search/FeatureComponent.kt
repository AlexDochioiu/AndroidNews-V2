package com.github.alexdochioiu.search

import com.github.alexdochioiu.androidnewsv2.di.Feature_UiScope
import com.github.alexdochioiu.androidnewsv2.di.InjectableComponent
import com.github.alexdochioiu.search.ui.DashboardFragment
import com.github.alexdochioiu.search_networking.di.SearchNetworkComponent
import dagger.Component

/**
 * Created by Alex Dochioiu on 2019-05-17
 */
@Feature_UiScope
@Component(dependencies = [SearchNetworkComponent::class])
interface FeatureComponent : InjectableComponent<DashboardFragment> {
}

/*
fun FeatureComponent.inject() {
    DaggerFeatureComponent
}*/
