package com.jfalstaff.flashtradingmarket.presentation.pageOne

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.jfalstaff.flashtradingmarket.R
import com.jfalstaff.flashtradingmarket.TradeMarketApp
import com.jfalstaff.flashtradingmarket.databinding.FragmentPageOneBinding
import com.jfalstaff.flashtradingmarket.domain.AppState
import com.jfalstaff.flashtradingmarket.presentation.ViewModelFactory
import com.jfalstaff.flashtradingmarket.presentation.adapters.FlashSaleAdapter
import com.jfalstaff.flashtradingmarket.presentation.adapters.LatestAdapter
import javax.inject.Inject

class PageOneFragment : Fragment() {

    private var _binding: FragmentPageOneBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val viewModel by lazy {
        ViewModelProvider(requireActivity(), viewModelFactory)[PageOneViewModel::class.java]
    }

    private val component by lazy {
        (requireActivity().application as TradeMarketApp).component
    }
    lateinit var latestAdapter: LatestAdapter
    lateinit var flashSaleAdapter: FlashSaleAdapter

    override fun onAttach(context: Context) {
        component.inject(this)
        activity?.findViewById<TextView>(R.id.toolbarTitleTextView)?.text =
            getString(R.string.page_one_title_toolbar)
        activity?.findViewById<ImageView>(R.id.avatarAppbarImageView)?.visibility = View.VISIBLE
        activity?.findViewById<ImageView>(R.id.menuImageView)?.visibility = View.VISIBLE
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPageOneBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        observeData()
    }

    private fun initRecyclerView() {
        latestAdapter = LatestAdapter()
        binding.latestRecyclerView.adapter = latestAdapter
        flashSaleAdapter = FlashSaleAdapter()
        binding.flashSaleRecyclerView.adapter = flashSaleAdapter
    }

    private fun observeData() {
        viewModel.getAllData()
        viewModel.goodsResult.observe(viewLifecycleOwner) { state ->
            renderData(state)
        }
    }

    private fun renderData(state: AppState?) {
        when(state) {
            is AppState.SuccessApiResults -> {
                latestAdapter.submitList(state.results.first.latest)
                flashSaleAdapter.submitList(state.results.second.flashSale)
            }
            is AppState.Error -> {
                Toast.makeText(requireActivity(), "Error: ${state.error.message}", Toast.LENGTH_SHORT).show()
            }
            else -> {
                Toast.makeText(requireActivity(), "Error", Toast.LENGTH_SHORT).show()
            }
        }
    }

    companion object {
        fun newInstance() = PageOneFragment()
    }
}