package com.example.skcbinterview.data

import android.content.Context
import com.example.skcbinterview.Constants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApiClient(val context: Context) {

    val apiClientService:ApiService by lazy { provideApiService() }

    companion object{
        const val CONNECTION_TIME_OUT = 20000L
        const val WRITE_TIME_OUT = 20000L
        const val READ_TIME_OUT = 20000L

        fun getInstance(context: Context): ApiClient = ApiClient(context.applicationContext)
    }

    private fun provideOkHttpClient():OkHttpClient{
        return OkHttpClient.Builder().run {
            connectTimeout(CONNECTION_TIME_OUT,TimeUnit.MILLISECONDS)
            writeTimeout(WRITE_TIME_OUT,TimeUnit.MILLISECONDS)
            readTimeout(READ_TIME_OUT,TimeUnit.MILLISECONDS)
            build()
        }
    }

    private fun provideRetrofit(client: OkHttpClient):Retrofit{
        return Retrofit.Builder().run {
            baseUrl(Constants.BASE_URL)
            client(client)
            addConverterFactory(GsonConverterFactory.create())
            build()
        }
    }

    private fun provideApiService():ApiService{
        val okHttpClient = provideOkHttpClient()
        val retrofit = provideRetrofit(okHttpClient)
        return retrofit.create(ApiService::class.java)
    }
}