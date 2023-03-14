package com.jfalstaff.flashtradingmarket.presentation.pageTwo

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.jfalstaff.flashtradingmarket.R
import com.jfalstaff.flashtradingmarket.TradeMarketApp
import com.jfalstaff.flashtradingmarket.databinding.FragmentPageTwoBinding
import com.jfalstaff.flashtradingmarket.presentation.CardFragment
import com.jfalstaff.flashtradingmarket.presentation.ViewModelFactory
import com.jfalstaff.flashtradingmarket.presentation.adapters.CarouselAdapter
import com.jfalstaff.flashtradingmarket.presentation.profile.IOnLogoutAndFinishListener
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem
import javax.inject.Inject


class PageTwoFragment : Fragment() {

    private var _binding: FragmentPageTwoBinding? = null
    private val binding get() = _binding!!
    private lateinit var onLogoutAndFinishListener: IOnLogoutAndFinishListener
    private var carouselAdapter: CarouselAdapter? = null

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val viewModel by lazy {
        ViewModelProvider(requireActivity(), viewModelFactory)[PageTwoViewModel::class.java]
    }
    private val component by lazy {
        (requireActivity().application as TradeMarketApp).component
    }

    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)
        if (context is IOnLogoutAndFinishListener) {
            onLogoutAndFinishListener = context
        } else {
            throw RuntimeException(getString(R.string.activity_must_implement_listener))
        }
        setCustomToolbar()
    }

    private fun setCustomToolbar() {
        activity?.findViewById<ImageView>(R.id.avatarAppbarImageView)?.visibility = View.GONE
        activity?.findViewById<TextView>(R.id.locationTextView)?.visibility = View.GONE
        activity?.findViewById<ImageView>(R.id.menuImageView)
            ?.setImageResource(R.drawable.ic_arrow_back)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPageTwoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeData()
        changeTotalInfo()
        setBackToolbarClickListener()
        addToFavourite()
        shareProduct()
        addToCard()
    }

    private fun addToCard() {
        binding.addToCardLayout.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.container, CardFragment.newInstance())
                .addToBackStack(null)
                .commit()
        }
    }

    private fun shareProduct() {
        binding.addToFavouriteButton.setOnClickListener {
            Toast.makeText(
                requireActivity(),
                getString(R.string.add_to_favourite),
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun addToFavourite() {
        binding.shareButton.setOnClickListener {
            Toast.makeText(
                requireActivity(),
                getString(R.string.share),
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun changeTotalInfo() {
        viewModel.count.observe(viewLifecycleOwner) {
            binding.quantityTextView.text = String.format(getString(R.string.quantity), it)
        }

        binding.addButton.setOnClickListener {
            viewModel.addItem()
        }
        binding.deleteButton.setOnClickListener {
            viewModel.deleteItem()
        }

        viewModel.total.observe(viewLifecycleOwner) {
            binding.totalPriceTextView.text = String.format(getString(R.string.total_sum), it)
        }
    }

    private fun observeData() {
        viewModel.detailInfo.observe(viewLifecycleOwner) { info ->
            renderData(info)
            viewModel.getItemPrice(info.price)
        }
    }

    private fun renderData(detailInfo: com.jfalstaff.domain.entity.DetailInfo) = with(binding) {
        productDescriptionInfoTextView.text = detailInfo.description
        productNameInfoTextView.text = detailInfo.name
        productPriceInfoTextView.text =
            String.format(getString(R.string.price_info), detailInfo.price)
        Glide.with(requireActivity())
            .load(detailInfo.imageUrls.first())
            .into(productPictureDetailImageView)
        ratingTextView.text = detailInfo.rating.toString()
        reviewTextView.text =
            String.format(getString(R.string.reviews_count), detailInfo.numberOfReviews)
        setColor(detailInfo.colors)
        setCarousel(detailInfo.imageUrls)
    }

    private fun setCarousel(imageUrls: List<String>) {
        binding.imageCarousel.registerLifecycle(viewLifecycleOwner)
        carouselAdapter = CarouselAdapter()
        binding.imageCarousel.carouselListener = carouselAdapter
        val imagesList = mutableListOf<CarouselItem>()
        for (image in imageUrls) {
            imagesList.add(CarouselItem(imageUrl = image))
        }
        binding.imageCarousel.setData(imagesList)
        carouselAdapter?.onItemClick = {
            Glide.with(requireActivity())
                .load(it.imageUrl)
                .into(binding.productPictureDetailImageView)
        }
    }

    private fun setColor(colors: List<String>) {
        val color1 = colors[0]
        val color2 = colors[1]
        val color3 = colors[2]
        binding.colorRadioGroup.findViewById<RadioButton>(R.id.colorOne).buttonTintList =
            ColorStateList.valueOf(Color.parseColor(color1))
        binding.colorRadioGroup.findViewById<RadioButton>(R.id.colorTwo).buttonTintList =
            ColorStateList.valueOf(Color.parseColor(color2))
        binding.colorRadioGroup.findViewById<RadioButton>(R.id.colorThree).buttonTintList =
            ColorStateList.valueOf(Color.parseColor(color3))
    }

    private fun setBackToolbarClickListener() {
        requireActivity().findViewById<ImageView>(R.id.menuImageView).setOnClickListener {
            onLogoutAndFinishListener.backToolbarListener()
        }
    }

    companion object {
        fun newInstance() = PageTwoFragment()
    }
}