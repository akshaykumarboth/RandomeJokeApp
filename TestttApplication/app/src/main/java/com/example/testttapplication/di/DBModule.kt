package com.example.testttapplication.di

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.testttapplication.data.local.JokesDatabase
import com.example.testttapplication.data.local.JokesDao
import org.koin.dsl.module


val jokesDBModule = module {

    fun provideDb(application: Application): JokesDatabase {
        val db = Room.databaseBuilder(
            application,
            JokesDatabase::class.java, "jokes_db"
        ).fallbackToDestructiveMigration()
            .setJournalMode(RoomDatabase.JournalMode.AUTOMATIC).addCallback(object :
                RoomDatabase.Callback() {
                override fun onCreate(db: SupportSQLiteDatabase) {
                    super.onCreate(db)
                    println("=====================JokesDB onCreate")
                }

                override fun onOpen(db: SupportSQLiteDatabase) {
                    super.onOpen(db)
                    println("=====================JokesDB onOpen")
                }

                override fun onDestructiveMigration(db: SupportSQLiteDatabase) {
                    super.onDestructiveMigration(db)
                    println("=====================JokesDB onDestructiveMigration")
                }
            }).build()

        println("========================JokesDB db=== $db")
        return db
    }

    fun provideJokesDao(db: JokesDatabase): JokesDao {
        return db.jokesDao()
    }

    single { provideDb(get()) }
    single { provideJokesDao(get<JokesDatabase>()) }
}