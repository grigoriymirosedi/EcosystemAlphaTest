package com.example.ecosystemalphatest.di

import com.example.ecosystemalphatest.presentation.MainActivity
import dagger.Component

@Component(modules = [NetworkModule::class, RepositoryModule::class])
interface AppComponent {
    fun inject(activity: MainActivity)
}