package com.jfalstaff.domain.usecases

import com.jfalstaff.domain.IUserRepository
import javax.inject.Inject

class CheckUserUseCase @Inject constructor(private val userRepository: IUserRepository) {
    suspend operator fun invoke(name: String) = userRepository.checkIsUserExist(name)
}