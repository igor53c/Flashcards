package com.ipcoding.flashcards.feature.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ipcoding.flashcards.feature.domain.model.Word

@Database(
    entities = [Word::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract val wordDao: WordDao

    companion object {
        const val DATABASE_NAME = "flashcards_db"
    }
}