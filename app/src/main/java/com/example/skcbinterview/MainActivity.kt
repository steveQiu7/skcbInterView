package com.example.skcbinterview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.skcbinterview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val mVB by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mVB.root)


    }

    fun initView(){

    }


}