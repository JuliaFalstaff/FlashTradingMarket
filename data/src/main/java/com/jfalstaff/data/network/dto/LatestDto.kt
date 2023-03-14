package com.jfalstaff.data.network.dto


import com.google.gson.annotations.SerializedName

data class LatestDto(
    @SerializedName("latest")
    val latest: List<LatestGoodsDto>
)