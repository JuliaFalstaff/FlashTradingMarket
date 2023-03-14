package com.jfalstaff.flashtradingmarket.presentation.adapters

import androidx.recyclerview.widget.DiffUtil
import com.jfalstaff.flashtradingmarket.domain.entity.FlashSale

class ItemFlashSaleDiffCallback : DiffUtil.ItemCallback<FlashSale>() {
    override fun areItemsTheSame(oldItem: FlashSale, newItem: FlashSale) = oldItem == newItem

    override fun areContentsTheSame(oldItem: FlashSale, newItem: FlashSale) = oldItem == newItem
}