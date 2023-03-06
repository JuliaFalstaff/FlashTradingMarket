package com.jfalstaff.flashtradingmarket.presentation.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.jfalstaff.flashtradingmarket.TradeMarketApp
import com.jfalstaff.flashtradingmarket.databinding.FragmentLoginBinding
import com.jfalstaff.flashtradingmarket.domain.AppState
import com.jfalstaff.flashtradingmarket.presentation.ProfileActivity
import com.jfalstaff.flashtradingmarket.presentation.ViewModelFactory
import javax.inject.Inject

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val viewModel by lazy {
        ViewModelProvider(requireActivity(), viewModelFactory)[LoginViewModel::class.java]
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
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.user.observe(viewLifecycleOwner) {
            when(it) {
                is AppState.Success -> {
                    Toast.makeText(requireActivity(), "Login success", Toast.LENGTH_SHORT).show()
                    Log.d("VVV login", it.user.toString())
                    Intent(requireActivity(), ProfileActivity::class.java).apply {
                        startActivity(this)
                    }
                }
                is AppState.Error -> {
                    Toast.makeText(requireActivity(), "Wrong Data: ${it.error}", Toast.LENGTH_SHORT).show()
                }
            }
        }
        binding.loginButton.setOnClickListener {
            val name = binding.firstNameEditText.text.toString().trim()
            val password = binding.passwordEditText.text.toString().trim()
            if (name.isNotEmpty() && password.isNotEmpty()) {
                viewModel.getUser(name)
            } else {
                Toast.makeText(requireActivity(), "Check you fill up all forms", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    companion object {
        fun newInstance() = LoginFragment()
    }
}