@file:Suppress("ClassName")

package com.github.alexdochioiu.androidnewsv2.di

import javax.inject.Scope

@Retention(AnnotationRetention.SOURCE)
@Scope
annotation class AppScope

@Retention(AnnotationRetention.SOURCE)
@Scope
annotation class Feature_NetworkingPersistenceScope

@Retention(AnnotationRetention.SOURCE)
@Scope
annotation class Feature_UiScope