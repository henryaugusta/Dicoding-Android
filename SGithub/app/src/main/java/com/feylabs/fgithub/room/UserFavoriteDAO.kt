package com.feylabs.fgithub.room
import android.database.Cursor
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserFavoriteDAO {

    @Insert
    suspend fun addUser(user: UserFavorite)

    @Query("SELECT EXISTS (SELECT * FROM fav_user WHERE github_id = :git_id)")
    suspend fun checkIfFavorito(git_id: Int):Boolean

    @Query("DELETE FROM fav_user WHERE id = :user_id")
    suspend fun deleteUser(user_id: Int)

    @Query("DELETE FROM fav_user WHERE github_id = :github_id")
    suspend fun deleteUserByGitID(github_id: Int)

    @Query("SELECT * FROM fav_user")
    suspend fun getUsers():MutableList<UserFavorite>

    @Query("SELECT * FROM fav_user where id = :user_id")
    suspend fun geUser(user_id:Int):List<UserFavorite>

    @Query("SELECT * FROM fav_user")
    fun selectAll(): Cursor?
}