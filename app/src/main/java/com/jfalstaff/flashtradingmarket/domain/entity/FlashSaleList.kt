package com.jfalstaff.flashtradingmarket.domain.entity


import com.google.gson.annotations.SerializedName

data class FlashSaleList(
    @SerializedName("flash_sale")
    val flashSale: List<FlashSale>
)