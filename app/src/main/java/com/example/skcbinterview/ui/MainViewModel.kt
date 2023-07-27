package com.example.skcbinterview.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.skcbinterview.data.ApiRepository
import com.example.skcbinterview.data.ResourceStatus
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class MainViewModel(private val apiRepository: ApiRepository):ViewModel() {

    val TAG = MainViewModel::class.java.simpleName

    suspend fun apiGetMuseumIntroduction() {
        apiRepository.getApiMuseumIntroduction().collect {
            when (it) {
                is ResourceStatus.Success -> {
                    Log.d(TAG, "$it")
                }
                is ResourceStatus.Error -> {

                }
                is ResourceStatus.Loading -> {

                }
            }
        }

    }
}