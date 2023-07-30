package com.example.skcbinterview

import android.app.Application
import android.util.Log

class MyApp : Application() {

    companion object {
        val TAG: String = MyApp::class.java.simpleName

        private lateinit var instance: MyApp
        fun getInstance() = instance
    }

    init {
        instance = this
    }

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "MyApp running")
    }
}