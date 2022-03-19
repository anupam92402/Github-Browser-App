package com.example.githubbrowser.data.remote

import com.example.githubbrowser.data.model.Users
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface GithubApiService {

    @Headers("Accept: application/vnd.github.v3+json")
    @GET("users/{user}/repos")
    suspend fun getUserList(@Path("user") user: String): Response<Users>
}