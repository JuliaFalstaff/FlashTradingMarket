package com.jfalstaff.data.mapper

import com.jfalstaff.data.model.UserProfileDbModel
import com.jfalstaff.domain.entity.UserProfile
import javax.inject.Inject

class UserMapper @Inject constructor() {

    fun mapUserEntityToDbModel(userProfile: UserProfile): UserProfileDbModel {
        return UserProfileDbModel(
            id = 0,
            firstName = userProfile.firstName,
            lastName = userProfile.lastName,
            email = userProfile.email
        )
    }

    fun mapUserDbModelToEntity(userProfileDb: UserProfileDbModel): UserProfile {
        return UserProfile(
            firstName = userProfileDb.firstName,
            lastName = userProfileDb.lastName,
            email = userProfileDb.email
        )
    }
}