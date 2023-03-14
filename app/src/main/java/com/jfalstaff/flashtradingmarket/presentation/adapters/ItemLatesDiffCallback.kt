package com.jfalstaff.flashtradingmarket.presentation.adapters

import androidx.recyclerview.widget.DiffUtil
import com.jfalstaff.domain.entity.LatestGoods

class ItemLatesDiffCallback : DiffUtil.ItemCallback<com.jfalstaff.domain.entity.LatestGoods>() {
    override fun areItemsTheSame(oldItem: com.jfalstaff.domain.entity.LatestGoods, newItem: com.jfalstaff.domain.entity.LatestGoods) = oldItem == newItem

    override fun areContentsTheSame(oldItem: com.jfalstaff.domain.entity.LatestGoods, newItem: com.jfalstaff.domain.entity.LatestGoods) = oldItem == newItem
}