package com.neal786y.mvparchitecture.di.component

import com.neal786y.mvparchitecture.di.module.ApiModule
import com.neal786y.mvparchitecture.di.module.AppModule
import com.neal786y.mvparchitecture.main.activity.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class, ApiModule::class))
interface ApiComponent {
    fun inject(mainActivity: MainActivity)
}