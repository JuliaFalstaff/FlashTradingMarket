package com.jfalstaff.flashtradingmarket.domain.usecases

import com.jfalstaff.flashtradingmarket.domain.IRepository
import javax.inject.Inject

class GetSearchResultUseCase @Inject constructor(private val repository: IRepository) {

    suspend operator fun invoke() = repository.getSearchResult()
}