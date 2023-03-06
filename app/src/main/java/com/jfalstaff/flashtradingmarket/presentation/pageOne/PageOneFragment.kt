package com.jfalstaff.flashtradingmarket.presentation.pageOne

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.jfalstaff.flashtradingmarket.TradeMarketApp
import com.jfalstaff.flashtradingmarket.databinding.FragmentPageOneBinding

class PageOneFragment: Fragment() {

    private var _binding: FragmentPageOneBinding? = null
    private val binding get() = _binding!!

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

    companion object {
        fun newInstance() = PageOneFragment()
    }
}