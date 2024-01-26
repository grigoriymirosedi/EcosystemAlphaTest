package com.example.ecosystemalphatest.app

import android.app.Application
import com.example.ecosystemalphatest.di.AppComponent
import com.example.ecosystemalphatest.di.DaggerAppComponent

class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        initDagger()
    }

    private fun initDagger() {
        appComponent = DaggerAppComponent.create()
    }
}