package com.example.testttapplication.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.testttapplication.data.model.JokeResponse


@Database(entities = arrayOf(JokeResponse::class), version = 1, exportSchema = false)
abstract class JokesDatabase : RoomDatabase() {
    abstract fun jokesDao(): JokesDao
}