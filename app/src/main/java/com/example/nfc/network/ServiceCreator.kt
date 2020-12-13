package com.example.nfc.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceCreator {
    //用户数据请求根路径
    private const val USER_BASE_URL = "https://login.entropy2020.cn/rfid/"

    private val userRetrofit = Retrofit.Builder()
        .baseUrl(USER_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun <T> userCreate(serviceClass:Class<T>):T = userRetrofit.create(serviceClass)

    //inline fun <reified T> create():T = create(T::class.java)
}