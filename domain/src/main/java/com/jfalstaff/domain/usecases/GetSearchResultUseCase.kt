package com.jfalstaff.domain.usecases

import com.jfalstaff.domain.IRepository
import javax.inject.Inject

class GetSearchResultUseCase @Inject constructor(private val repository: IRepository) {

    suspend operator fun invoke() = repository.getSearchResult()
}