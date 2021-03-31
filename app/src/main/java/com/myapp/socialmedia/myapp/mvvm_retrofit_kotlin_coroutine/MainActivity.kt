package com.myapp.socialmedia.myapp.mvvm_retrofit_kotlin_coroutine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.myapp.socialmedia.myapp.mvvm_retrofit_kotlin_coroutine.adapter.PostAdapter
import com.myapp.socialmedia.myapp.mvvm_retrofit_kotlin_coroutine.model.Post
import com.myapp.socialmedia.myapp.mvvm_retrofit_kotlin_coroutine.repository.PostRepository
import com.myapp.socialmedia.myapp.mvvm_retrofit_kotlin_coroutine.viewmodel.PostViewModel
import com.myapp.socialmedia.myapp.mvvm_retrofit_kotlin_coroutine.viewmodel.PostViewModelFactory


class MainActivity : AppCompatActivity() {
    private lateinit var postRepository: PostRepository
    private lateinit var postViewModelFactory: PostViewModelFactory
    private lateinit var postViewModel: PostViewModel
    private lateinit var recyclerView:RecyclerView
    private lateinit var postAdapter:PostAdapter
    private lateinit var progressBar:ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()
        postRepository= PostRepository()
        postViewModelFactory= PostViewModelFactory(postRepository)
        postViewModel=ViewModelProvider(this,postViewModelFactory).get(PostViewModel::class.java)
        postViewModel.getPost()

        postViewModel.myResponse.observe(this,
                {response->
            postAdapter.setPostData(response as ArrayList<Post>)

            progressBar.visibility=View.GONE
            recyclerView.visibility=View.VISIBLE
        })
    }

    private fun initRecyclerView() {
        recyclerView=findViewById(R.id.recyclerView)
        progressBar=findViewById(R.id.progressBar)
        postAdapter= PostAdapter(this, ArrayList())
        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager= LinearLayoutManager(this@MainActivity)
            adapter=postAdapter
        }
    }
}

