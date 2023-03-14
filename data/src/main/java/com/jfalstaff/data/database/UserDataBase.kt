package com.jfalstaff.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jfalstaff.data.model.UserProfileDbModel

@Database(entities = [UserProfileDbModel::class], version = 2, exportSchema = false)
abstract class UserDataBase : RoomDatabase() {
    abstract fun userDao(): UserDao
}