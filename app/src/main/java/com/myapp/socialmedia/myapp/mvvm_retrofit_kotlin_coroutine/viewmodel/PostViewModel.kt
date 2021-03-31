package com.myapp.socialmedia.myapp.mvvm_retrofit_kotlin_coroutine.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.myapp.socialmedia.myapp.mvvm_retrofit_kotlin_coroutine.model.Post
import com.myapp.socialmedia.myapp.mvvm_retrofit_kotlin_coroutine.repository.PostRepository
import kotlinx.coroutines.launch
import java.lang.Exception

class PostViewModel(private val postrepository: PostRepository):ViewModel() {

    val myResponse:MutableLiveData<List<Post>> = MutableLiveData()
    fun getPost()
    {
        //to show the retrofit data and jump back to main thread
        // we use launch instead of again creating suspend function here
        viewModelScope.launch {
            try {
                myResponse.value= postrepository.getPost()
            }
            catch (e:Exception)
            {
                e.printStackTrace()
            }
        }
    }

}