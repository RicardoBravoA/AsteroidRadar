package com.udacity.asteroid.radar.data.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.udacity.asteroid.radar.data.BuildConfig
import com.udacity.asteroid.radar.data.util.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit

object ApiManager {

    private var apiInterface: ApiInterface? = null

    private val retrofit: Retrofit
        get() {

            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.NONE

            if (BuildConfig.DEBUG) {
                logging.level = HttpLoggingInterceptor.Level.BODY
            }

            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(logging)
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .build()

            return Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build()
        }

    fun get(): ApiInterface {

        if (apiInterface == null) {
            apiInterface = retrofit.create(ApiInterface::class.java)
        }

        return apiInterface!!
    }

}