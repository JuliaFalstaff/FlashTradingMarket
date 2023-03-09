package com.jfalstaff.flashtradingmarket.presentation.pageOne

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jfalstaff.flashtradingmarket.domain.AppState
import com.jfalstaff.flashtradingmarket.domain.GoodsState
import com.jfalstaff.flashtradingmarket.domain.entity.FlashSale
import com.jfalstaff.flashtradingmarket.domain.entity.FlashSaleList
import com.jfalstaff.flashtradingmarket.domain.entity.Latest
import com.jfalstaff.flashtradingmarket.domain.usecases.GetFlashSaleUseCase
import com.jfalstaff.flashtradingmarket.domain.usecases.GetLatestGoodsUseCase
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

class PageOneViewModel @Inject constructor(
    private val getLatestGoodsUseCase: GetLatestGoodsUseCase,
    private val getFlashSaleUseCase: GetFlashSaleUseCase
) : ViewModel() {

//    private val _latest: MutableLiveData<Latest> = MutableLiveData()
//    val latest: LiveData<Latest> = _latest
//    private val _flashSale: MutableLiveData<FlashSaleList> = MutableLiveData()
//    val flashSale: LiveData<FlashSaleList> = _flashSale
//    private val _goodsState: MutableLiveData<GoodsState> = MutableLiveData()
//    val goodsState: LiveData<GoodsState> = _goodsState

    private val _goodsResult: MutableLiveData<AppState> = MutableLiveData()
    val goodsResult: LiveData<AppState> = _goodsResult

    fun getAllData() {
        viewModelScope.launch {
            val latestData = async { getLatestGoodsUseCase() }
            val flashSaleData = async { getFlashSaleUseCase() }
            try {
                val result = Pair(latestData.await(), flashSaleData.await())
                _goodsResult.postValue(AppState.SuccessApiResults(result))
            } catch (e: Throwable) {
                _goodsResult.postValue(AppState.Error(e))
            }
        }
    }




//    private fun getLatest() {
//        viewModelScope.launch {
//            val latestData = getLatestGoodsUseCase()
//            _latest.value = latestData
//        }
//    }
//
//    private fun getFlashSale() {
//        viewModelScope.launch {
//            val flashSale = getFlashSaleUseCase()
//            _flashSale.value = flashSale
//        }
//    }
//
//    fun getAllData() {
//        viewModelScope.launch {
//            val latest = async { getLatest() }
//            val flash = async { getFlashSale() }
//            try {
//                val latestResult = latest.await()
//                val flashResult = flash.await()
//                Log.d("VVV VM", "$flash. $latest")
//            } catch (error: Throwable ) {

//            }

//        }
//    }
}