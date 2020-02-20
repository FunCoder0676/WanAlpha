package com.funny.common.network

import com.funny.common.BuildConfig
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object HttpManager {

    private val DEFAULT_CONNECT_TIMEOUT = 15L
    private val DEFAULT_WRITE_TIMEOUT = 15L
    private val DEFAULT_READ_TIMEOUT = 15L
    private lateinit var mRetrofit: Retrofit

    fun init() {
        mRetrofit =
            Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/")
                .client(provideOkHttpClient())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .build()
    }

    private fun provideOkHttpClient(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        if (BuildConfig.DEBUG) {
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        } else {
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.NONE)
        }
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .connectTimeout(DEFAULT_CONNECT_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(DEFAULT_WRITE_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(DEFAULT_READ_TIMEOUT, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
            .build()
    }

    fun <T> create(service: Class<T>): T = mRetrofit.create(service)

}