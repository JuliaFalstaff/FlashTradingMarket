package com.jfalstaff.flashtradingmarket.presentation.pageOne

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jfalstaff.flashtradingmarket.domain.entity.Latest
import com.jfalstaff.flashtradingmarket.domain.usecases.GetLatestGoodsUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class PageOneViewModel @Inject constructor(
    private val getLatestGoodsUseCase: GetLatestGoodsUseCase
) : ViewModel() {



    private val _latest: MutableLiveData<Latest> = MutableLiveData()
    val latest: LiveData<Latest> = _latest

    fun getLatest() {
        viewModelScope.launch {
                val latestData = getLatestGoodsUseCase()
                _latest.value = latestData
        }
    }
}