package com.jfalstaff.flashtradingmarket.domain.usecases

import com.jfalstaff.flashtradingmarket.domain.IRepository
import javax.inject.Inject

class GetLatestGoodsUseCase @Inject constructor(private val repository: IRepository) {

    suspend operator fun invoke() = repository.getLatestGoods()
}