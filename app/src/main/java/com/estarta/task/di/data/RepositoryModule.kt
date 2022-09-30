package com.estarta.task.di.data

import com.estarta.task.data.data_source.HomeRemoteDataSource
import com.estarta.task.domain.repository.HomeRepository
import com.estarta.task.domain.repository.HomeRepositoryImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideHomeRepository(homeRemoteDataSource: HomeRemoteDataSource): HomeRepository {
        return HomeRepositoryImp(homeRemoteDataSource)
    }
}