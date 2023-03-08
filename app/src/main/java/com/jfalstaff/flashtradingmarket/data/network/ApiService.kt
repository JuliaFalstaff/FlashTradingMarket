package com.jfalstaff.flashtradingmarket.data.network

import com.jfalstaff.flashtradingmarket.data.network.dto.LatestDto
import retrofit2.http.GET

interface ApiService {

    @GET("v3/cc0071a1-f06e-48fa-9e90-b1c2a61eaca7")
    suspend fun getLatestGoods(): LatestDto

    @GET("v3/a9ceeb6e-416d-4352-bde6-2203416576ac")
    suspend fun getFlashSale()

}