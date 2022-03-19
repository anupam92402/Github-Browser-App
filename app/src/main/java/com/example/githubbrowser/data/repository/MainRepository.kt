package com.example.githubbrowser.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.githubbrowser.data.model.Users
import com.example.githubbrowser.data.remote.GithubApiService

class MainRepository constructor(private val githubApiService: GithubApiService) {

    private val userLiveData = MutableLiveData<Users>()

    val users: LiveData<Users>
        get() = userLiveData

    suspend fun getUsers() {
        val result = githubApiService.getUserList("anupam92402")
        if (result.body() != null) {
            Log.d("detail:-", result.body().toString())
            userLiveData.postValue(result.body())
        }
    }
}