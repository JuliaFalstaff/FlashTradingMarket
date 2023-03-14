package com.jfalstaff.flashtradingmarket.data.repository

import com.jfalstaff.flashtradingmarket.data.database.UserDao
import com.jfalstaff.flashtradingmarket.data.mapper.UserMapper
import com.jfalstaff.domain.IUserRepository
import com.jfalstaff.domain.entity.UserProfile
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userDao: UserDao,
    private val userMapper: UserMapper
) : com.jfalstaff.domain.IUserRepository {

    override suspend fun signInNewUserAndSave(userProfile: com.jfalstaff.domain.entity.UserProfile) {
        userDao.signInNewUserAndSave(userMapper.mapUserEntityToDbModel(userProfile))
    }

    override suspend fun getUserProfile(name: String): com.jfalstaff.domain.entity.UserProfile {
        return userMapper.mapUserDbModelToEntity(userDao.getUserProfile(name))
    }

    override suspend fun checkIsUserExist(name: String): Boolean {
        return userDao.checkIsUserExist(name)
    }
}