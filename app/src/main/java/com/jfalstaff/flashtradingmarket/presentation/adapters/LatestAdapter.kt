package com.jfalstaff.flashtradingmarket.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jfalstaff.flashtradingmarket.R
import com.jfalstaff.flashtradingmarket.databinding.ItemLatestRvBinding
import com.jfalstaff.domain.entity.LatestGoods

class LatestAdapter :
    ListAdapter<com.jfalstaff.domain.entity.LatestGoods, LatestAdapter.LatestViewHolder>(ItemLatesDiffCallback()) {

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
        fun bind(latest: com.jfalstaff.domain.entity.LatestGoods) = with(binding) {
            productCategoryTextView.text = latest.category
            productNameTextView.text = latest.name
            priceTextView.text = String.format(
                itemView.context.getString(R.string.price_info),
                latest.price
            )
            Glide.with(itemView)
                .load(latest.imageUrl)
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(productPicture)
        }
    }
}