package com.jfalstaff.flashtradingmarket.domain

import com.jfalstaff.flashtradingmarket.domain.entity.DetailInfo
import com.jfalstaff.flashtradingmarket.domain.entity.FlashSaleList
import com.jfalstaff.flashtradingmarket.domain.entity.Latest
import com.jfalstaff.flashtradingmarket.domain.entity.Search

interface IRepository {
    suspend fun getLatestGoods(): Latest
    suspend fun getFlashSale(): FlashSaleList
    suspend fun getDetailInfo(): DetailInfo
    suspend fun getSearchResult(): Search
}