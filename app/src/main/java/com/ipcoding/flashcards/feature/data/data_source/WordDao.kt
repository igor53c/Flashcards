package com.ipcoding.flashcards.feature.data.data_source

import androidx.room.*
import com.ipcoding.flashcards.feature.domain.model.Word

@Dao
interface WordDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWord(word: Word)

    @Delete
    suspend fun deleteWord(word: Word)

    @Query("DELETE FROM words_table")
    suspend fun deleteAll()

    @Query("SELECT * FROM words_table WHERE numberOfHits = :numberOfHits "
            + "ORDER BY id ASC LIMIT 100")
    suspend fun getWords(numberOfHits: Int): List<Word>
}