package com.jfalstaff.flashtradingmarket.presentation.pageOne

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jfalstaff.flashtradingmarket.domain.AppState
import com.jfalstaff.flashtradingmarket.domain.usecases.GetFlashSaleUseCase
import com.jfalstaff.flashtradingmarket.domain.usecases.GetLatestGoodsUseCase
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

class PageOneViewModel @Inject constructor(
    private val getLatestGoodsUseCase: GetLatestGoodsUseCase,
    private val getFlashSaleUseCase: GetFlashSaleUseCase
) : ViewModel() {

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
}