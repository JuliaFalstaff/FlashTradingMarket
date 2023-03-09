package com.jfalstaff.flashtradingmarket.presentation.pageTwo

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.jfalstaff.flashtradingmarket.R
import com.jfalstaff.flashtradingmarket.TradeMarketApp
import com.jfalstaff.flashtradingmarket.databinding.FragmentPageTwoBinding
import com.jfalstaff.flashtradingmarket.presentation.ViewModelFactory
import com.jfalstaff.flashtradingmarket.presentation.pageOne.PageOneViewModel
import javax.inject.Inject

class PageTwoFragment: Fragment() {

    private var _binding: FragmentPageTwoBinding? = null
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
        _binding = FragmentPageTwoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    companion object {
        fun newInstance() = PageTwoFragment()
    }
}