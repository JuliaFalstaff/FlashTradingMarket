package com.jfalstaff.flashtradingmarket.presentation.adapters

import androidx.recyclerview.widget.DiffUtil
import com.jfalstaff.flashtradingmarket.domain.entity.FlashSale
import com.jfalstaff.flashtradingmarket.domain.entity.FlashSaleList
import com.jfalstaff.flashtradingmarket.domain.entity.Latest
import com.jfalstaff.flashtradingmarket.domain.entity.LatestGoods

class ItemFlashSaleDiffCallback: DiffUtil.ItemCallback<FlashSale>() {
    override fun areItemsTheSame(oldItem: FlashSale, newItem: FlashSale) = oldItem == newItem

    override fun areContentsTheSame(oldItem: FlashSale, newItem: FlashSale) = oldItem == newItem
}