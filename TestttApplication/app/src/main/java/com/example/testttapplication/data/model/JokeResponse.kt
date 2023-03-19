package com.example.testttapplication.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/*
* entity table of DB and response data class
* */
@Entity(tableName = "Jokes")
data class JokeResponse (
    @PrimaryKey
    @SerializedName("joke")
    var joke: String = ""
) {
}