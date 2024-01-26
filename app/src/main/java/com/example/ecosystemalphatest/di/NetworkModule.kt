package com.example.ecosystemalphatest.di

import com.example.ecosystemalphatest.core.Constants
import com.example.ecosystemalphatest.data.remote.api.NewYorkTimesAPI
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule {

    @Provides
    fun provideGsonConverter(): Gson {
        return GsonBuilder().setDateFormat("yyyy-MM-dd").create()
    }

    @Provides
    fun provideOkHttpInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().setLevel(level = HttpLoggingInterceptor.Level.BODY)

    @Provides
    fun provideOkHttpClient(loginInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(loginInterceptor)
            .build()
    }

    @Provides
    fun provideRetrofit(gson: Gson, okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson)).client(okHttpClient).build()

    @Provides
    fun provideAPI(retrofit: Retrofit): NewYorkTimesAPI =
        retrofit.create(NewYorkTimesAPI::class.java)

}