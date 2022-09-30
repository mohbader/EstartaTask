package com.estarta.task.di.data

import com.estarta.task.data.data_source.HomeRemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteDataSourceModule {

    @Provides
    @Singleton
    fun provideHomeRemoteDataSource(retrofit: Retrofit): HomeRemoteDataSource {
        return retrofit.create(HomeRemoteDataSource::class.java)
    }
}