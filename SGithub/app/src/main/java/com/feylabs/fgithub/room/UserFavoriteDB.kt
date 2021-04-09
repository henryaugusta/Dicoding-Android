package com.feylabs.fgithub.room
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(
entities = [UserFavorite::class],
version = 2
)
abstract class UserFavoriteDB : RoomDatabase(){

    abstract fun userFavoriteDao() : UserFavoriteDAO

    companion object {

        @Volatile private var instance : UserFavoriteDB? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
            context.applicationContext,
            UserFavoriteDB::class.java,
            "user_favoritoz.db"
        ).build()
    }

}