package com.example.githubbrowser.data.remote

import retrofit2.http.GET
import retrofit2.http.Path

interface GithubApiService {

    @GET("/users/{user}/repos")
    suspend fun getUser(@Path("user") user: String)
}