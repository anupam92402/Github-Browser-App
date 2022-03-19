package com.example.githubbrowser

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.githubbrowser.data.remote.GithubApiService
import com.example.githubbrowser.databinding.ActivityMainBinding
import com.example.githubbrowser.ui.adapter.ViewPagerAdapter
import com.example.githubbrowser.utils.ApiUtilities
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val titleArray = listOf("Users", "Repositories", "Trending")
//    lateinit var viewModel: MainViewModel//view model

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

        val githubApiService = ApiUtilities.getInstance()
            .create(GithubApiService::class.java)

//        val repository = MainRepository(githubApiService)
//
//        viewModel =
//            ViewModelProvider(this, MainViewModelFactory(repository))
//                .get(MainViewModel::class.java)
//
//        viewModel.users.observe(this,{
//            Log.d("Tagg","OnCreate:- ${it.full_name}")
//        })

        getUser(githubApiService)

    }

    private fun getUser(githubApiService: GithubApiService) {
        GlobalScope.launch {
            val result = githubApiService.getUserList("anupam92402")
            Toast.makeText(applicationContext, result.code(), Toast.LENGTH_LONG).show()
            if (result.body() != null) {
                Log.d("Tagg", result.code().toString())
            }
            Toast.makeText(applicationContext, result.code(), Toast.LENGTH_LONG).show()
        }
    }
}