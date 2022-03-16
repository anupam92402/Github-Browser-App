package com.example.githubbrowser.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.githubbrowser.ui.fragment.RepositoryFragment
import com.example.githubbrowser.ui.fragment.TrendingRepoFragment
import com.example.githubbrowser.ui.fragment.UserFragment

//view Pager Adapter to do swipe fragments in main activity

class ViewPagerAdapter(fragmentActivity: FragmentActivity, private val titleArray: List<String>) :
    FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
        return titleArray.size
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> UserFragment()
            1 -> RepositoryFragment()
            2 -> TrendingRepoFragment()
            else -> UserFragment()
        }
    }
}