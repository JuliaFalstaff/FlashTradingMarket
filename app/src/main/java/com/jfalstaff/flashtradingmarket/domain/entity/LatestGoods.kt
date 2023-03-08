package com.jfalstaff.flashtradingmarket.domain.entity


import com.google.gson.annotations.SerializedName

data class LatestGoods(
    val category: String,
    val imageUrl: String,
    val name: String,
    val price: Int
)