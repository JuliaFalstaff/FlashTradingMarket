package com.jfalstaff.flashtradingmarket.data.mapper

import com.jfalstaff.flashtradingmarket.data.model.UserProfileDbModel
import com.jfalstaff.domain.entity.UserProfile
import javax.inject.Inject

class UserMapper @Inject constructor() {

    fun mapUserEntityToDbModel(userProfile: com.jfalstaff.domain.entity.UserProfile): UserProfileDbModel {
        return UserProfileDbModel(
            id = 0,
            firstName = userProfile.firstName,
            lastName = userProfile.lastName,
            email = userProfile.email
        )
    }

    fun mapUserDbModelToEntity(userProfileDb: UserProfileDbModel): com.jfalstaff.domain.entity.UserProfile {
        return com.jfalstaff.domain.entity.UserProfile(
            firstName = userProfileDb.firstName,
            lastName = userProfileDb.lastName,
            email = userProfileDb.email
        )
    }
}