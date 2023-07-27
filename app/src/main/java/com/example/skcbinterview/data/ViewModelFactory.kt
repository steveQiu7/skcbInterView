package com.example.skcbinterview.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.skcbinterview.ui.MainActivity
import com.example.skcbinterview.ui.MainViewModel


class ViewModelFactory(private val apiRepository: ApiRepository):ViewModelProvider.Factory {

    companion object{
        fun getInstance(apiRepository: ApiRepository):ViewModelFactory = ViewModelFactory(apiRepository)
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when{
            modelClass.isAssignableFrom(MainViewModel::class.java) -> MainViewModel(apiRepository) as T
            else->throw IllegalArgumentException("UnKnow class name")
        }
    }

}