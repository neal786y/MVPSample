package com.neal786y.mvparchitecture.di.component

import com.neal786y.mvparchitecture.di.module.AdapterModule
import com.neal786y.mvparchitecture.di.module.ApiModule
import com.neal786y.mvparchitecture.di.module.AppModule
import com.neal786y.mvparchitecture.di.module.PresenterModule
import com.neal786y.mvparchitecture.main.activity.DetailWebActivity
import com.neal786y.mvparchitecture.main.activity.MainActivity
import com.neal786y.mvparchitecture.splash.activity.SplashActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class, ApiModule::class, PresenterModule::class, AdapterModule::class))
interface ApiComponent {
    fun inject(mainActivity: MainActivity)

    fun inject(detailWebActivity: DetailWebActivity)

    fun inject(splashActivity: SplashActivity)
}