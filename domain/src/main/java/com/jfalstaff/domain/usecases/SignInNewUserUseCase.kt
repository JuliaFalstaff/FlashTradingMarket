package com.jfalstaff.domain.usecases

import com.jfalstaff.domain.IUserRepository
import com.jfalstaff.domain.entity.UserProfile
import javax.inject.Inject

class SignInNewUserUseCase @Inject constructor(private val userRepository: IUserRepository) {
    suspend operator fun invoke(userProfile: UserProfile) =
        userRepository.signInNewUserAndSave(userProfile)
}