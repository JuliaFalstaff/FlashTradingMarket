package com.jfalstaff.flashtradingmarket.data.network.dto


import com.google.gson.annotations.SerializedName

data class LatestDto(
    @SerializedName("latest")
    val latest: List<LatestGoodsDto>
)