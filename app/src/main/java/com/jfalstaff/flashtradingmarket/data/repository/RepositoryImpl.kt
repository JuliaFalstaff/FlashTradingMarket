package com.jfalstaff.flashtradingmarket.data.repository

import com.jfalstaff.flashtradingmarket.data.mapper.GoodsMapper
import com.jfalstaff.flashtradingmarket.data.network.ApiService
import com.jfalstaff.flashtradingmarket.domain.IRepository
import com.jfalstaff.flashtradingmarket.domain.entity.FlashSaleList
import com.jfalstaff.flashtradingmarket.domain.entity.Latest
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val goodsMapper: GoodsMapper
) : IRepository {

    override suspend fun getLatestGoods(): Latest {
        return goodsMapper.mapLatestDtoToEntity(apiService.getLatestGoods())
    }

    override suspend fun getFlashSale(): FlashSaleList {
        return goodsMapper.mapFlashSaleListDtoToEntity(apiService.getFlashSale())
    }
}