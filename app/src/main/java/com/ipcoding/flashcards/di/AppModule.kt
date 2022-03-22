package com.ipcoding.flashcards.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.ipcoding.flashcards.core.data.DefaultPreferences
import com.ipcoding.flashcards.core.domain.preferences.Preferences
import com.ipcoding.flashcards.feature.data.data_source.AppDatabase
import com.ipcoding.flashcards.feature.data.repository.WordRepositoryImpl
import com.ipcoding.flashcards.feature.domain.repository.WordRepository
import com.ipcoding.flashcards.feature.domain.use_case.AllUseCases
import com.ipcoding.flashcards.feature.domain.use_case.CreateDatabase
import com.ipcoding.flashcards.feature.domain.use_case.GetRandomWord
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
    fun provideSharedPreferences(app: Application): SharedPreferences {
        return app.getSharedPreferences("shared_pref", Context.MODE_PRIVATE)
    }

    @Provides
    @Singleton
    fun providePreferences(sharedPreferences: SharedPreferences): Preferences {
        return DefaultPreferences(sharedPreferences)
    }

    @Provides
    @Singleton
    fun provideUseCases(
        wordRepository: WordRepository,
        preferences: Preferences
    ): AllUseCases {
        return AllUseCases(
            createDatabase = CreateDatabase(wordRepository, preferences),
            getRandomWord = GetRandomWord(wordRepository)
        )
    }
}