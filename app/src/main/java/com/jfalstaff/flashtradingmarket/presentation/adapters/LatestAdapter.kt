package com.jfalstaff.flashtradingmarket.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jfalstaff.flashtradingmarket.R
import com.jfalstaff.flashtradingmarket.databinding.ItemLatestRvBinding
import com.jfalstaff.flashtradingmarket.domain.entity.FlashSale
import com.jfalstaff.flashtradingmarket.domain.entity.LatestGoods

class LatestAdapter : ListAdapter<LatestGoods, LatestAdapter.LatestViewHolder>(ItemLatesDiffCallback()) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): LatestAdapter.LatestViewHolder {
        return LatestViewHolder(
            ItemLatestRvBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: LatestAdapter.LatestViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class LatestViewHolder(private val binding: ItemLatestRvBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(latest: LatestGoods) = with(binding) {
            productCategoryTextView.text = latest.category
            productNameTextView.text = latest.name
            priceTextView.text = latest.price.toString()
            Glide.with(itemView)
                .load(latest.imageUrl)
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(productPicture)

        }
    }
}