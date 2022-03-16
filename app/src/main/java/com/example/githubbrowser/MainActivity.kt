package com.example.githubbrowser

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.githubbrowser.databinding.ActivityMainBinding
import com.example.githubbrowser.ui.adapter.ViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val titleArray = listOf("Users", "Repositories", "Trending")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //view pager and tab layout
        val pagerAdapter = ViewPagerAdapter(this, titleArray)
        binding.viewPager.adapter = pagerAdapter
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = titleArray[position]
        }.attach()

    }
}