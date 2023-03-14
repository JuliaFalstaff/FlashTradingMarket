package com.jfalstaff.flashtradingmarket.domain.entity


data class LatestGoods(
    val category: String,
    val imageUrl: String,
    val name: String,
    val price: Int
)