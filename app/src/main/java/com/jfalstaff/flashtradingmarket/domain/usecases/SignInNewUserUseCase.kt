package com.jfalstaff.flashtradingmarket.domain.usecases

import com.jfalstaff.flashtradingmarket.domain.IUserRepository
import com.jfalstaff.flashtradingmarket.domain.entity.UserProfile
import javax.inject.Inject

class SignInNewUserUseCase @Inject constructor(private val userRepository: IUserRepository) {
    suspend operator fun invoke(userProfile: UserProfile) =
        userRepository.signInNewUserAndSave(userProfile)
}