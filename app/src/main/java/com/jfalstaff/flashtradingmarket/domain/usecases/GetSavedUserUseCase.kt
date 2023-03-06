package com.jfalstaff.flashtradingmarket.domain.usecases

import com.jfalstaff.flashtradingmarket.domain.IUserRepository
import javax.inject.Inject

class GetSavedUserUseCase @Inject constructor(private val userRepository: IUserRepository) {
    suspend operator fun invoke(name: String) = userRepository.getUserProfile(name)
}