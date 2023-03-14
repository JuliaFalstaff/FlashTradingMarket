package com.jfalstaff.domain.usecases

import com.jfalstaff.domain.IUserRepository
import javax.inject.Inject

class GetSavedUserUseCase @Inject constructor(private val userRepository: IUserRepository) {
    suspend operator fun invoke(name: String) = userRepository.getUserProfile(name)
}