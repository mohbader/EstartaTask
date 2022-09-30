package com.estarta.task.di.data

import com.estarta.task.domain.repository.HomeRepository
import com.estarta.task.domain.use_case.GetHomeDataUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideGetHomeDataUseCase(homeRepository: HomeRepository): GetHomeDataUseCase {
        return GetHomeDataUseCase(homeRepository)
    }
}