package com.jfalstaff.domain.entity


data class DetailInfo(
    val colors: List<String>,
    val description: String,
    val imageUrls: List<String>,
    val name: String,
    val numberOfReviews: Int,
    val price: Int,
    val rating: Double
)