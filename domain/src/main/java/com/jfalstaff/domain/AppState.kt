package com.jfalstaff.domain

import com.jfalstaff.domain.entity.FlashSaleList
import com.jfalstaff.domain.entity.Latest
import com.jfalstaff.domain.entity.UserProfile

sealed class AppState {
    object Loading: AppState()
    data class Error(val error: Throwable): AppState()
    data class ErrorMessage(val errorMessage: String): AppState()
    data class Success(val user: UserProfile): AppState()
    data class SuccessApiResults(val results: Pair<Latest, FlashSaleList>): AppState()
}