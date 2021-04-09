package com.feylabs.fgithub.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "fav_user")
data class UserFavorite(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val name : String,
    val github_id : Int,
    val url : String,
    val photo_url : String,
    val organization : String,
    val det_url : String
)