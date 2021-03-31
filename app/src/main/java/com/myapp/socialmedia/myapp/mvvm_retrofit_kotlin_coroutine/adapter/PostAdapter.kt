package com.myapp.socialmedia.myapp.mvvm_retrofit_kotlin_coroutine.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.myapp.socialmedia.myapp.mvvm_retrofit_kotlin_coroutine.MainActivity
import com.myapp.socialmedia.myapp.mvvm_retrofit_kotlin_coroutine.R
import com.myapp.socialmedia.myapp.mvvm_retrofit_kotlin_coroutine.model.Post

class PostAdapter(private val context: Context,private var postList:ArrayList<Post>)
    : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder =
            PostViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_view,parent,false))

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        //val post=postList[position]
        val post=postList.get(position)
        holder.id.text=post.id.toString()
        holder.title.text=post.title
    }

    override fun getItemCount(): Int = postList.size

    class PostViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView)
    {
        val id:TextView=itemView.findViewById(R.id.id)
        val title:TextView=itemView.findViewById(R.id.title)
    }

    fun setPostData(postList: ArrayList<Post>)
    {
        this.postList=postList
        notifyDataSetChanged()
    }
}
