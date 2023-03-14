package com.jfalstaff.flashtradingmarket.presentation.adapters

import androidx.recyclerview.widget.DiffUtil
import com.jfalstaff.domain.entity.LatestGoods

class ItemLatestDiffCallback : DiffUtil.ItemCallback<LatestGoods>() {
    override fun areItemsTheSame(
        oldItem: LatestGoods,
        newItem: LatestGoods
    ) = oldItem == newItem

    override fun areContentsTheSame(
        oldItem: LatestGoods,
        newItem: LatestGoods
    ) = oldItem == newItem
}