package com.jfalstaff.flashtradingmarket.domain

import com.jfalstaff.flashtradingmarket.domain.entity.UserProfile

interface IUserRepository {
    suspend fun signInNewUserAndSave(userProfile: UserProfile)
    suspend fun getUserProfile(name: String): UserProfile
    suspend fun checkIsUserExist(name: String): Boolean
}