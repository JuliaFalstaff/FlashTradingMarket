package com.jfalstaff.domain

import com.jfalstaff.domain.entity.UserProfile

interface IUserRepository {
    suspend fun signInNewUserAndSave(userProfile: UserProfile)
    suspend fun getUserProfile(name: String): UserProfile
    suspend fun checkIsUserExist(name: String): Boolean
}