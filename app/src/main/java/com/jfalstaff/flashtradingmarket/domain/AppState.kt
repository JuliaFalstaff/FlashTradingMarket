package com.jfalstaff.flashtradingmarket.domain

import com.jfalstaff.flashtradingmarket.domain.entity.UserProfile

sealed class AppState {
    object Loading: AppState()
    data class Error(val error: Throwable): AppState()
    data class ErrorMessage(val errorMessage: String): AppState()
    data class Success(val user: UserProfile): AppState()
}