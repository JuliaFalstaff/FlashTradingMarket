package com.jfalstaff.flashtradingmarket.data.repository

import com.jfalstaff.flashtradingmarket.data.mapper.GoodsMapper
import com.jfalstaff.flashtradingmarket.data.mapper.SearchMapper
import com.jfalstaff.flashtradingmarket.data.network.ApiService
import com.jfalstaff.flashtradingmarket.domain.IRepository
import com.jfalstaff.flashtradingmarket.domain.entity.DetailInfo
import com.jfalstaff.flashtradingmarket.domain.entity.FlashSaleList
import com.jfalstaff.flashtradingmarket.domain.entity.Latest
import com.jfalstaff.flashtradingmarket.domain.entity.Search
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val goodsMapper: GoodsMapper,
    private val searchMapper: SearchMapper
) : IRepository {

    override suspend fun getLatestGoods(): Latest {
        return goodsMapper.mapLatestDtoToEntity(apiService.getLatestGoods())
    }

    override suspend fun getFlashSale(): FlashSaleList {
        return goodsMapper.mapFlashSaleListDtoToEntity(apiService.getFlashSale())
    }

    override suspend fun getDetailInfo(): DetailInfo {
        return goodsMapper.mapDetailInfoDtoToEntity(apiService.getDetailInfo())
    }

    override suspend fun getSearchResult(): Search {
        return searchMapper.mapSearchResultDtoToEntity(apiService.getSearchResult())
    }
}