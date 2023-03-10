package com.jfalstaff.flashtradingmarket.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jfalstaff.flashtradingmarket.R
import com.jfalstaff.flashtradingmarket.databinding.ItemFlashSaleRvBinding
import com.jfalstaff.flashtradingmarket.domain.entity.FlashSale
import com.jfalstaff.flashtradingmarket.domain.entity.FlashSaleList

class FlashSaleAdapter :
    ListAdapter<FlashSale, FlashSaleAdapter.FlashSaleViewHolder>(ItemFlashSaleDiffCallback()) {

    var flashSaleItemClickListener: ((FlashSale) ->Unit)? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FlashSaleAdapter.FlashSaleViewHolder {
        return FlashSaleViewHolder(
            ItemFlashSaleRvBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: FlashSaleAdapter.FlashSaleViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class FlashSaleViewHolder(private val binding: ItemFlashSaleRvBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(flashSale: FlashSale) = with(binding) {
            productCategoryTextView.text = flashSale.category
            productNameTextView.text = flashSale.name
            priceTextView.text = flashSale.price.toString()
            saleTextView.text = flashSale.discount.toString()
            Glide.with(itemView)
                .load(flashSale.imageUrl)
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(productPicture)
            itemView.setOnClickListener {
                flashSaleItemClickListener?.invoke(flashSale)
            }
        }
    }
}