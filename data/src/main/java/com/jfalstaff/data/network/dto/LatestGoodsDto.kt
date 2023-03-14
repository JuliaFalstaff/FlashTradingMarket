package com.jfalstaff.data.network.dto


import com.google.gson.annotations.SerializedName

data class LatestGoodsDto(
    @SerializedName("category")
    val category: String,
    @SerializedName("image_url")
    val imageUrl: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("price")
    val price: Int
)