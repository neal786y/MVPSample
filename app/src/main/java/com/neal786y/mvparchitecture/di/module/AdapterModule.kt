package com.neal786y.mvparchitecture.di.module

import com.neal786y.mvparchitecture.main.adaper.NewsAdapter
import com.neal786y.mvparchitecture.main.adaper.SourceAdapter
import dagger.Module
import dagger.Provides

@Module
class AdapterModule {

    @Provides
    fun provideNewsAdapter() : NewsAdapter = NewsAdapter()

    @Provides
    fun provideSourceAdapter() : SourceAdapter= SourceAdapter()
}