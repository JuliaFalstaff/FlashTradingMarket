package com.jfalstaff.flashtradingmarket.domain.entity


import com.google.gson.annotations.SerializedName

data class DetailInfo(
    @SerializedName("colors")
    val colors: List<String>,
    @SerializedName("description")
    val description: String,
    @SerializedName("image_urls")
    val imageUrls: List<String>,
    @SerializedName("name")
    val name: String,
    @SerializedName("number_of_reviews")
    val numberOfReviews: Int,
    @SerializedName("price")
    val price: Int,
    @SerializedName("rating")
    val rating: Double
)