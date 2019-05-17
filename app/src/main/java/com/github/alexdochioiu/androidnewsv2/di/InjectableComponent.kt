package com.github.alexdochioiu.androidnewsv2.di

/**
 * Created by Alexandru Iustin Dochioiu on 21-Mar-19
 *
 */
interface InjectableComponent<T> {
    fun inject(parent: T) : T
}