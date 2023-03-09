package com.jfalstaff.flashtradingmarket.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import com.jfalstaff.flashtradingmarket.R
import com.jfalstaff.flashtradingmarket.databinding.FragmentProfileBinding
import com.jfalstaff.flashtradingmarket.presentation.login.MainActivity

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onAttach(context: Context) {
        activity?.findViewById<TextView>(R.id.toolbarTitleTextView)?.text =
            getString(R.string.profile)
        activity?.findViewById<ImageView>(R.id.avatarAppbarImageView)?.visibility = View.GONE
        activity?.findViewById<ImageView>(R.id.menuImageView)?.visibility = View.GONE
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        logOut()
        downloadUserImage()
    }

    private fun downloadUserImage() = with(binding) {
        val contract = ActivityResultContracts.GetContent()
        val launcherImage = registerForActivityResult(contract) {
            profileAvatarImageView.setImageURI(it)
        }
        changePhotoTextView.setOnClickListener {
            launcherImage.launch("image/*")
        }
    }

    private fun logOut() {
        binding.logoutTextView.setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack()
            Intent(activity, MainActivity::class.java).apply {
                startActivity(this)
            }
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    companion object {
        fun newInstance() = ProfileFragment()
    }
}