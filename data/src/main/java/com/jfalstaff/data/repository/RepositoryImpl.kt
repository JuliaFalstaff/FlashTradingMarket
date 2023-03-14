package com.jfalstaff.data.repository

import com.jfalstaff.data.mapper.GoodsMapper
import com.jfalstaff.data.mapper.SearchMapper
import com.jfalstaff.data.network.ApiService
import com.jfalstaff.domain.IRepository
import com.jfalstaff.domain.entity.DetailInfo
import com.jfalstaff.domain.entity.FlashSaleList
import com.jfalstaff.domain.entity.Latest
import com.jfalstaff.domain.entity.Search
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val goodsMapper: GoodsMapper,
    private val searchMapper: SearchMapper
) : com.jfalstaff.domain.IRepository {

    override suspend fun getLatestGoods(): com.jfalstaff.domain.entity.Latest {
        return goodsMapper.mapLatestDtoToEntity(apiService.getLatestGoods())
    }

    override suspend fun getFlashSale(): com.jfalstaff.domain.entity.FlashSaleList {
        return goodsMapper.mapFlashSaleListDtoToEntity(apiService.getFlashSale())
    }

    override suspend fun getDetailInfo(): com.jfalstaff.domain.entity.DetailInfo {
        return goodsMapper.mapDetailInfoDtoToEntity(apiService.getDetailInfo())
    }

    override suspend fun getSearchResult(): com.jfalstaff.domain.entity.Search {
        return searchMapper.mapSearchResultDtoToEntity(apiService.getSearchResult())
    }
}