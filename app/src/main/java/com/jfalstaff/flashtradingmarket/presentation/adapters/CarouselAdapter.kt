package com.jfalstaff.flashtradingmarket.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewbinding.ViewBinding
import com.jfalstaff.flashtradingmarket.databinding.ItemCustomCarouselBinding
import org.imaginativeworld.whynotimagecarousel.listener.CarouselListener
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem
import org.imaginativeworld.whynotimagecarousel.utils.setImage

class CarouselAdapter : CarouselListener {

    var onItemClick: ((CarouselItem) -> Unit)? = null

    override fun onCreateViewHolder(
        layoutInflater: LayoutInflater,
        parent: ViewGroup
    ): ViewBinding? {
        return ItemCustomCarouselBinding.inflate(layoutInflater, parent, false)
    }

    override fun onBindViewHolder(binding: ViewBinding, item: CarouselItem, position: Int) {
        val currentBinding = binding as ItemCustomCarouselBinding
        currentBinding.imageView.apply {
            scaleType = ImageView.ScaleType.CENTER_CROP
            setImage(item)
        }
        currentBinding.imageView.setOnClickListener {
            onItemClick?.invoke(item)
        }
    }
}
