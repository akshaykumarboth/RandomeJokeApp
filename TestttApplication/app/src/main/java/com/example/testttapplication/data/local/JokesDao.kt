package com.example.testttapplication.data.local

import androidx.room.*
import com.example.testttapplication.data.model.JokeResponse

@Dao
abstract class JokesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insert(joke: JokeResponse)

    //@Query("DELETE from jokes where BY id DESC LIMIT 1")
    //@Query("DELETE FROM jokes WHERE id IN (SELECT id FROM jokes ORDER BY id DESC LIMIT 1)")
    @Delete
    abstract suspend fun delete(joke: JokeResponse)

    @Query("SELECT * FROM jokes")
    abstract fun getAllJokes(): List<JokeResponse>

}