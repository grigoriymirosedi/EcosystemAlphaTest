package com.example.ecosystemalphatest.di

import com.example.ecosystemalphatest.data.remote.api.NewYorkTimesAPI
import com.example.ecosystemalphatest.data.repository.NewsRepositoryImpl
import com.example.ecosystemalphatest.domain.repository.NewsRepository
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun provideNewsRepository(newsAPI: NewYorkTimesAPI): NewsRepository =
        NewsRepositoryImpl(newsAPI)
}