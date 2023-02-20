package com.kirill1995.kazzak.utils.builder

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

fun buildRetrofit(url: String): Retrofit {
     val retrofit by lazy {
         val httpLoggingInterceptor = HttpLoggingInterceptor()
         httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
         val okHttpClient= OkHttpClient.Builder()
             .addInterceptor(httpLoggingInterceptor)
             .build()

         Retrofit.Builder()
             .baseUrl(url)
             .client(okHttpClient)
             .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
             .addConverterFactory(GsonConverterFactory.create())
             .build()
     }

    return retrofit
 }