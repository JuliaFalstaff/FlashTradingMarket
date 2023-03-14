package com.jfalstaff.flashtradingmarket.data.mapper

import com.jfalstaff.flashtradingmarket.data.network.dto.*
import javax.inject.Inject

class GoodsMapper @Inject constructor() {

    fun mapLatestDtoToEntity(latestDto: LatestDto): com.jfalstaff.domain.entity.Latest {
        return com.jfalstaff.domain.entity.Latest(
            latest = mapLatestGoodsDtoToEntity(latestDto.latest)
        )
    }

    private fun mapLatestGoodsDtoToEntity(latest: List<LatestGoodsDto>): List<com.jfalstaff.domain.entity.LatestGoods> {
        return latest.map {
            com.jfalstaff.domain.entity.LatestGoods(
                category = it.category,
                imageUrl = it.imageUrl,
                name = it.name,
                price = it.price
            )
        }
    }

    fun mapFlashSaleListDtoToEntity(flashSaleListDto: FlashSaleListDto): com.jfalstaff.domain.entity.FlashSaleList {
        return com.jfalstaff.domain.entity.FlashSaleList(
            flashSale = mapFlashSaleDtoToEntity(flashSaleListDto.flashSaleDto)
        )
    }

    private fun mapFlashSaleDtoToEntity(flash: List<FlashSaleDto>): List<com.jfalstaff.domain.entity.FlashSale> {
        return flash.map {
            com.jfalstaff.domain.entity.FlashSale(
                category = it.category,
                discount = it.discount,
                imageUrl = it.imageUrl,
                name = it.name,
                price = it.price
            )
        }
    }

    fun mapDetailInfoDtoToEntity(info: DetailInfoDto): com.jfalstaff.domain.entity.DetailInfo {
        return com.jfalstaff.domain.entity.DetailInfo(
            colors = info.colors,
            description = info.description,
            imageUrls = info.imageUrls,
            name = info.name,
            numberOfReviews = info.numberOfReviews,
            price = info.price,
            rating = info.rating
        )
    }
}