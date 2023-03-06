package com.jfalstaff.flashtradingmarket.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.jfalstaff.flashtradingmarket.R
import com.jfalstaff.flashtradingmarket.databinding.ActivityProfileBinding
import com.jfalstaff.flashtradingmarket.presentation.pageOne.PageOneFragment

class ProfileActivity : AppCompatActivity() {
    private var _binding: ActivityProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initBottomNavigation()
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, PageOneFragment.newInstance())
                .commit()
        }
    }

    private fun initBottomNavigation() {
        binding.bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when(menuItem.itemId) {
                R.id.menu_item_home -> {
                    openFragment(PageOneFragment.newInstance())
                    true
                }
                R.id.menu_item_favourite -> {
                    //TODO
                    true
                }
                R.id.menu_item_cart -> {
                    //TODO
                    true
                }
                R.id.menu_item_chat -> {
                    //TODO
                    true
                }
                R.id.menu_item_profile -> {
                    //TODO
                    true
                }
                else -> false
            }
        }
    }

    private fun openFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .addToBackStack(null)
            .commit()
    }
}