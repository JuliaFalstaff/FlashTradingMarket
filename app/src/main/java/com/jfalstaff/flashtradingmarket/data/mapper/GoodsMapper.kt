package com.jfalstaff.flashtradingmarket.data.mapper

import com.jfalstaff.flashtradingmarket.data.network.dto.*
import com.jfalstaff.flashtradingmarket.domain.entity.*
import javax.inject.Inject

class GoodsMapper @Inject constructor() {

    fun mapLatestDtoToEntity(latestDto: LatestDto): Latest {
        return Latest(
            latest = mapLatestGoodsDtoToEntity(latestDto.latest)
        )
    }

    private fun mapLatestGoodsDtoToEntity(latest: List<LatestGoodsDto>): List<LatestGoods> {
        return latest.map {
            LatestGoods(
                category = it.category,
                imageUrl = it.imageUrl,
                name = it.name,
                price = it.price
            )
        }
    }

    fun mapFlashSaleListDtoToEntity(flashSaleListDto: FlashSaleListDto): FlashSaleList {
        return FlashSaleList(
            flashSale = mapFlashSaleDtoToEntity(flashSaleListDto.flashSaleDto)
        )
    }

    private fun mapFlashSaleDtoToEntity(flash: List<FlashSaleDto>): List<FlashSale> {
        return flash.map {
            FlashSale(
                category = it.category,
                discount = it.discount,
                imageUrl = it.imageUrl,
                name = it.name,
                price = it.price
            )
        }
    }

    fun mapDetailInfoDtoToEntity(info: DetailInfoDto): DetailInfo {
        return DetailInfo(
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