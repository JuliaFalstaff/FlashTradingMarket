package com.jfalstaff.flashtradingmarket.presentation.pageTwo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jfalstaff.flashtradingmarket.domain.entity.DetailInfo
import com.jfalstaff.flashtradingmarket.domain.usecases.GetDetailInfoUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class PageTwoViewModel @Inject constructor(
    private val getDetailInfoUseCase: GetDetailInfoUseCase
) : ViewModel() {

    private val _detailInfo: MutableLiveData<DetailInfo> = MutableLiveData()
    val detailInfo: LiveData<DetailInfo> = _detailInfo

    private var initialCount = 0
    private var priceTotal = 0

    private val _count: MutableLiveData<Int> = MutableLiveData()
    val count: LiveData<Int> = _count

    private val _total: MutableLiveData<Int> = MutableLiveData()
    val total: LiveData<Int> = _total

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            val info = getDetailInfoUseCase()
            _detailInfo.value = info
        }
    }

    fun addItem() {
        _count.value = ++initialCount
        _total.value = initialCount * priceTotal
    }

    fun deleteItem() {
        if (initialCount == 0) return
        if (initialCount >= 0) {
            _count.value = --initialCount
            _total.value = initialCount * priceTotal
        }
    }

    fun getItemPrice(price: Int) {
        priceTotal = price
    }
}