package com.ipcoding.flashcards.di

import com.ipcoding.flashcards.feature.domain.use_case.AllUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideUseCases(): AllUseCases {
        return AllUseCases()
    }
}