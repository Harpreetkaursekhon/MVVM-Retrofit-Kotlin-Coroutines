package com.myapp.socialmedia.myapp.mvvm_retrofit_kotlin_coroutine.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.net.URL

class RetrofitBuilder {

//    companion object{
//        //fetch base url
//        private val retrofit:Retrofit by lazy {
//            Retrofit.Builder()
//                .baseUrl(Url.url)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build()
//        }
//        //fetch end points
//        val api:Api by lazy {
//            retrofit.create(Api::class.java)
//        }
//
//    }

    companion object{
        private val retrofit:Retrofit by lazy {
            Retrofit.Builder()
                    .baseUrl(Url.url)
                    .addConverterFactory(GsonConverterFactory.create()).build()
        }
        val api:Api by lazy {
            retrofit.create(Api::class.java)
        }
    }
}