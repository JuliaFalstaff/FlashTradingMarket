package com.jfalstaff.flashtradingmarket.presentation.pageOne

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.jfalstaff.flashtradingmarket.TradeMarketApp
import com.jfalstaff.flashtradingmarket.databinding.FragmentPageOneBinding
import com.jfalstaff.flashtradingmarket.presentation.ViewModelFactory
import javax.inject.Inject

class PageOneFragment: Fragment() {

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

    override fun onAttach(context: Context) {
        component.inject(this)
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
        viewModel.latest.observe(viewLifecycleOwner) {
            Log.d("VVV latest", it.latest.toString())
        }
        viewModel.flashSale.observe(viewLifecycleOwner) {
            Log.d("VVV flash", it.flashSaleDto.toString())
        }
        viewModel.getAllData()
    }

    companion object {
        fun newInstance() = PageOneFragment()
    }
}