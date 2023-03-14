package com.jfalstaff.data.network.dto


import com.google.gson.annotations.SerializedName

data class FlashSaleListDto(
    @SerializedName("flash_sale")
    val flashSaleDto: List<FlashSaleDto>
)