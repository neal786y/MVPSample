package com.neal786y.mvparchitecture.di.module

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(application: Application) {

    val mApplication: Application = application

    @Provides
    @Singleton
    fun provideApplication(): Application {
        return mApplication
    }


}