package com.jfalstaff.flashtradingmarket.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.jfalstaff.flashtradingmarket.data.model.UserProfileDbModel

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun signInNewUserAndSave(userProfile: UserProfileDbModel)

    @Query("SELECT * FROM user_profile WHERE firstName =:name ")
    suspend fun getUserProfile(name: String): UserProfileDbModel
}