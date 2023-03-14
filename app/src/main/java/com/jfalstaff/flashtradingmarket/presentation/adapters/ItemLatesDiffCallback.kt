package com.jfalstaff.flashtradingmarket.presentation.adapters

import androidx.recyclerview.widget.DiffUtil
import com.jfalstaff.flashtradingmarket.domain.entity.LatestGoods

class ItemLatesDiffCallback : DiffUtil.ItemCallback<LatestGoods>() {
    override fun areItemsTheSame(oldItem: LatestGoods, newItem: LatestGoods) = oldItem == newItem

    override fun areContentsTheSame(oldItem: LatestGoods, newItem: LatestGoods) = oldItem == newItem
}