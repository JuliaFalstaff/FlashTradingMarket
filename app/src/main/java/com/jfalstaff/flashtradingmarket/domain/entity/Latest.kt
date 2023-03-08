package com.jfalstaff.flashtradingmarket.domain.entity


import com.google.gson.annotations.SerializedName

data class Latest(
    val latest: List<LatestGoods>
)