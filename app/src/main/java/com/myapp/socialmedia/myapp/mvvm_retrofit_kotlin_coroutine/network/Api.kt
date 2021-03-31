package com.myapp.socialmedia.myapp.mvvm_retrofit_kotlin_coroutine.network

import com.myapp.socialmedia.myapp.mvvm_retrofit_kotlin_coroutine.model.Post
import retrofit2.http.GET

interface Api {

    @GET("posts")
    suspend fun getAllPost():List<Post>

}