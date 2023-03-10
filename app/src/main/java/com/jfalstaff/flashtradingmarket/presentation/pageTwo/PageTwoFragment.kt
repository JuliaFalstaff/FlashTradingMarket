package com.jfalstaff.flashtradingmarket.presentation.pageTwo

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.jfalstaff.flashtradingmarket.R
import com.jfalstaff.flashtradingmarket.TradeMarketApp
import com.jfalstaff.flashtradingmarket.databinding.FragmentPageTwoBinding
import com.jfalstaff.flashtradingmarket.domain.entity.DetailInfo
import com.jfalstaff.flashtradingmarket.presentation.ViewModelFactory
import com.jfalstaff.flashtradingmarket.presentation.profile.IOnLogoutAndFinishListener
import javax.inject.Inject

class PageTwoFragment : Fragment() {

    private var _binding: FragmentPageTwoBinding? = null
    private val binding get() = _binding!!
    private lateinit var onLogoutAndFinishListener: IOnLogoutAndFinishListener

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
    }

    private fun changeTotalInfo() {
        viewModel.count.observe(viewLifecycleOwner) {
            binding.quantityTextView.text = "Quantity: $it"
        }

        binding.addButton.setOnClickListener {
            viewModel.addItem()
        }
        binding.deleteButton.setOnClickListener {
            viewModel.deleteItem()
        }

        viewModel.total.observe(viewLifecycleOwner) {
            binding.totalPriceTextView.text = it.toString()
            Log.d("VVV price", it.toString())
        }
    }

    private fun observeData() {
        viewModel.detailInfo.observe(viewLifecycleOwner) { info ->
            renderData(info)
            viewModel.getItemPrice(info.price)
        }
    }

    private fun renderData(detailInfo: DetailInfo) = with(binding) {
        productDescriptionInfoTextView.text = detailInfo.description
        productNameInfoTextView.text = detailInfo.name
        productPriceInfoTextView.text = detailInfo.price.toString()
        Glide.with(requireActivity())
            .load(detailInfo.imageUrls.first())
            .into(productPictureDetailImageView)
        ratingTextView.text = detailInfo.rating.toString()
        reviewTextView.text = detailInfo.numberOfReviews.toString()
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