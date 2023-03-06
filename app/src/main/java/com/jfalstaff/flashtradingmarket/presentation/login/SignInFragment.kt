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
import com.jfalstaff.flashtradingmarket.R
import com.jfalstaff.flashtradingmarket.TradeMarketApp
import com.jfalstaff.flashtradingmarket.databinding.FragmentSignInPageBinding
import com.jfalstaff.flashtradingmarket.domain.AppState
import com.jfalstaff.flashtradingmarket.domain.entity.UserProfile
import com.jfalstaff.flashtradingmarket.presentation.ProfileActivity
import com.jfalstaff.flashtradingmarket.presentation.ViewModelFactory
import com.jfalstaff.flashtradingmarket.utils.isEmailValid
import javax.inject.Inject

class SignInFragment : Fragment() {

    private var _binding: FragmentSignInPageBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val viewModel by lazy {
        ViewModelProvider(
            requireActivity(),
            viewModelFactory
        )[SignInViewModel::class.java]
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
        _binding = FragmentSignInPageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        signInUser()
        observeUser()
        loginIntoExistingAccount()
    }

    private fun loginIntoExistingAccount() {
        binding.logInTextView.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.authContainer, LoginFragment.newInstance())
                .addToBackStack(null)
                .commit()
        }
    }

    private fun observeUser() {
        viewModel.newUser.observe(viewLifecycleOwner) {
            when (it) {
                is AppState.Success -> {
                    Toast.makeText(requireActivity(), "User Saved", Toast.LENGTH_SHORT).show()
                    Intent(requireActivity(), ProfileActivity::class.java).apply {
                        startActivity(this)
                    }
                }
                is AppState.ErrorMessage -> {
                    Toast.makeText(requireActivity(), "Error: ${it.errorMessage}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun signInUser() = with(binding) {
        binding.signInButton.setOnClickListener {
            val firstName = firstNameEditText.text.toString().trim()
            val lastName = lastNameEditText.text.toString().trim()
            val email = emailEditText.text.toString().trim()
            checkValidForm(email, firstName, lastName)
        }
    }

    private fun checkValidForm(
        email: String,
        firstName: String,
        lastName: String
    ) {
        if (email.isEmailValid() && firstName.isNotEmpty() && lastName.isNotEmpty()) {
            viewModel.checkUser(UserProfile(firstName, lastName, email))
            Log.d("VVV", "saved")
        } else {
            showError(email.isEmailValid())
            Log.d("VVV", "NOT SAVED")
        }
    }

    private fun showError(emailValid: Boolean) {
        if (!emailValid) {
            Toast.makeText(requireActivity(), "Email doesn't correct", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(requireActivity(), "Check you fill up all forms", Toast.LENGTH_SHORT)
                .show()
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    companion object {
        fun newInstance() = SignInFragment()
    }
}