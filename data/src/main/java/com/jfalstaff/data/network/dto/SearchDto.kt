package com.jfalstaff.data.network.dto


import com.google.gson.annotations.SerializedName

data class SearchDto(
    @SerializedName("words")
    val words: List<String>
)