package com.neal786y.mvparchitecture.di.module

import com.neal786y.mvparchitecture.main.presenter.DetailWebPresenter
import com.neal786y.mvparchitecture.main.presenter.MainPresenter
import com.neal786y.mvparchitecture.splash.presenter.SplashPresenter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PresenterModule {

    @Provides
    @Singleton
    fun provideMainPresenter(): MainPresenter = MainPresenter()

    @Provides
    @Singleton
    fun provideDetailWebPresenter(): DetailWebPresenter = DetailWebPresenter()

    @Provides
    @Singleton
    fun provideSplashPresenter(): SplashPresenter = SplashPresenter()
}