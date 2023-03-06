package com.jfalstaff.flashtradingmarket.data.repository

import com.jfalstaff.flashtradingmarket.data.database.UserDao
import com.jfalstaff.flashtradingmarket.data.mapper.UserMapper
import com.jfalstaff.flashtradingmarket.domain.IUserRepository
import com.jfalstaff.flashtradingmarket.domain.entity.UserProfile
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userDao: UserDao,
    private val userMapper: UserMapper
) : IUserRepository {

    override suspend fun signInNewUserAndSave(userProfile: UserProfile) {
        userDao.signInNewUserAndSave(userMapper.mapUserEntityToDbModel(userProfile))
    }

    override suspend fun getUserProfile(name: String): UserProfile {
        return userMapper.mapUserDbModelToEntity(userDao.getUserProfile(name))
    }
}