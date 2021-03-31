package com.myapp.socialmedia.myapp.mvvm_retrofit_kotlin_coroutine.repository

import com.myapp.socialmedia.myapp.mvvm_retrofit_kotlin_coroutine.model.Post
import com.myapp.socialmedia.myapp.mvvm_retrofit_kotlin_coroutine.network.RetrofitBuilder

class PostRepository {

    suspend fun getPost(): List<Post> = RetrofitBuilder.api.getAllPost()

}