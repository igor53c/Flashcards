package com.ipcoding.flashcards.feature.data.data_source

import androidx.room.*
import com.ipcoding.flashcards.feature.domain.model.Word

@Dao
interface WordDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWord(word: Word)

    @Delete
    suspend fun deleteWord(word: Word)

    @Query("SELECT * FROM words_table ORDER BY id ASC")
    suspend fun getWords(): List<Word>
}