package com.jfalstaff.flashtradingmarket.presentation.adapters

import androidx.recyclerview.widget.DiffUtil
import com.jfalstaff.domain.entity.FlashSale

class ItemFlashSaleDiffCallback : DiffUtil.ItemCallback<com.jfalstaff.domain.entity.FlashSale>() {
    override fun areItemsTheSame(oldItem: com.jfalstaff.domain.entity.FlashSale, newItem: com.jfalstaff.domain.entity.FlashSale) = oldItem == newItem

    override fun areContentsTheSame(oldItem: com.jfalstaff.domain.entity.FlashSale, newItem: com.jfalstaff.domain.entity.FlashSale) = oldItem == newItem
}