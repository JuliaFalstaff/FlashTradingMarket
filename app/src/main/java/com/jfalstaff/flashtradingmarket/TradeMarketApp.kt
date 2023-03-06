package com.jfalstaff.flashtradingmarket

import android.app.Application
import com.jfalstaff.flashtradingmarket.di.DaggerApplicationComponent

class TradeMarketApp: Application() {

    val component by lazy {
        DaggerApplicationComponent.builder().build()
    }

}