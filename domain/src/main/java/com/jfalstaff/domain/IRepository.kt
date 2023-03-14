package com.jfalstaff.domain

import com.jfalstaff.domain.entity.DetailInfo
import com.jfalstaff.domain.entity.FlashSaleList
import com.jfalstaff.domain.entity.Latest
import com.jfalstaff.domain.entity.Search

interface IRepository {
    suspend fun getLatestGoods(): Latest
    suspend fun getFlashSale(): FlashSaleList
    suspend fun getDetailInfo(): DetailInfo
    suspend fun getSearchResult(): Search
}