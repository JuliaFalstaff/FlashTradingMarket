package com.jfalstaff.flashtradingmarket.domain.usecases

import com.jfalstaff.flashtradingmarket.domain.IRepository
import javax.inject.Inject

class GetFlashSaleUseCase @Inject constructor(private val repository: IRepository) {

    suspend operator fun invoke() = repository.getFlashSale()
}