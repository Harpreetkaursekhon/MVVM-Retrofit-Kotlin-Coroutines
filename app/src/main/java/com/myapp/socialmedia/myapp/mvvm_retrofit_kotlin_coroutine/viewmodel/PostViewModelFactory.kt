package com.myapp.socialmedia.myapp.mvvm_retrofit_kotlin_coroutine.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.myapp.socialmedia.myapp.mvvm_retrofit_kotlin_coroutine.repository.PostRepository

class PostViewModelFactory(private val postRepository: PostRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PostViewModel(postRepository) as T
    }
}