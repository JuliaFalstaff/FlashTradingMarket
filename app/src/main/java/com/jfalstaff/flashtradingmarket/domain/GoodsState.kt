package com.jfalstaff.flashtradingmarket.domain

import com.jfalstaff.flashtradingmarket.domain.entity.FlashSaleList
import com.jfalstaff.flashtradingmarket.domain.entity.Latest

sealed class GoodsState {
    object Loading : GoodsState()
    data class Error(val error: Throwable) : GoodsState()
    data class Success(val latest: Latest, val flash: FlashSaleList) : GoodsState()
}