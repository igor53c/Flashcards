package com.ipcoding.flashcards.di

import android.app.Application
import androidx.room.Room
import com.ipcoding.flashcards.feature.data.data_source.AppDatabase
import com.ipcoding.flashcards.feature.data.repository.WordRepositoryImpl
import com.ipcoding.flashcards.feature.domain.repository.WordRepository
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
    fun provideAppDatabase(app: Application): AppDatabase {
        return Room.databaseBuilder(
            app,
            AppDatabase::class.java,
            AppDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideWordRepository(db: AppDatabase): WordRepository {
        return WordRepositoryImpl(db.wordDao)
    }

    @Provides
    @Singleton
    fun provideUseCases(): AllUseCases {
        return AllUseCases()
    }
}