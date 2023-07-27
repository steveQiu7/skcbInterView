package com.example.skcbinterview.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.skcbinterview.data.ApiClient
import com.example.skcbinterview.data.ApiRepository
import com.example.skcbinterview.data.ApiService
import com.example.skcbinterview.data.ViewModelFactory
import com.example.skcbinterview.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val mVB by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private lateinit var mMainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mVB.root)
        setViewModel()
        getApi()
    }

    fun initView() {

    }

    private fun setViewModel() {
        val apiClient = ApiClient.getInstance(this)
        val apiRepository = ApiRepository.getInstance(apiClient.apiClientService)
        mMainViewModel = ViewModelProvider(this,ViewModelFactory.getInstance(apiRepository))[MainViewModel::class.java]
    }

    private fun getApi() {
        CoroutineScope(Dispatchers.IO).launch {
            mMainViewModel.apiGetMuseumIntroduction()
        }
    }
}