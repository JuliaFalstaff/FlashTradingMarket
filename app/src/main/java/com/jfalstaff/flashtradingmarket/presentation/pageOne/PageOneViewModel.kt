package com.jfalstaff.flashtradingmarket.presentation.pageOne

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jfalstaff.domain.AppState
import com.jfalstaff.domain.usecases.GetFlashSaleUseCase
import com.jfalstaff.domain.usecases.GetLatestGoodsUseCase
import com.jfalstaff.domain.usecases.GetSearchResultUseCase
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

class PageOneViewModel @Inject constructor(
    private val getLatestGoodsUseCase: com.jfalstaff.domain.usecases.GetLatestGoodsUseCase,
    private val getFlashSaleUseCase: com.jfalstaff.domain.usecases.GetFlashSaleUseCase,
    private val getSearchResultUseCase: com.jfalstaff.domain.usecases.GetSearchResultUseCase
) : ViewModel() {

    private val _goodsResult: MutableLiveData<com.jfalstaff.domain.AppState> = MutableLiveData()
    val goodsResult: LiveData<com.jfalstaff.domain.AppState> = _goodsResult

    private val _searchResult: MutableLiveData<List<String>> = MutableLiveData()
    val searchResult: LiveData<List<String>> = _searchResult

    fun getAllData() {
        viewModelScope.launch {
            val latestData = async { getLatestGoodsUseCase() }
            val flashSaleData = async { getFlashSaleUseCase() }
            try {
                val result = Pair(latestData.await(), flashSaleData.await())
                _goodsResult.postValue(com.jfalstaff.domain.AppState.SuccessApiResults(result))
            } catch (e: Throwable) {
                _goodsResult.postValue(com.jfalstaff.domain.AppState.Error(e))
            }
        }
    }

    fun getSearchResult() {
        viewModelScope.launch {
            val result = getSearchResultUseCase()
            delay(1000L)
            _searchResult.value = result.words
        }
    }
}