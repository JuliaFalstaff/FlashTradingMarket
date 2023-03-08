package com.jfalstaff.flashtradingmarket.domain

import com.jfalstaff.flashtradingmarket.domain.entity.FlashSaleList
import com.jfalstaff.flashtradingmarket.domain.entity.Latest

interface IRepository {
    suspend fun getLatestGoods(): Latest
    suspend fun getFlashSale(): FlashSaleList
}