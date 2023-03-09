package com.jfalstaff.flashtradingmarket.data.mapper

import com.jfalstaff.flashtradingmarket.data.network.dto.FlashSaleDto
import com.jfalstaff.flashtradingmarket.data.network.dto.FlashSaleListDto
import com.jfalstaff.flashtradingmarket.data.network.dto.LatestDto
import com.jfalstaff.flashtradingmarket.data.network.dto.LatestGoodsDto
import com.jfalstaff.flashtradingmarket.domain.entity.FlashSale
import com.jfalstaff.flashtradingmarket.domain.entity.FlashSaleList
import com.jfalstaff.flashtradingmarket.domain.entity.Latest
import com.jfalstaff.flashtradingmarket.domain.entity.LatestGoods
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

}