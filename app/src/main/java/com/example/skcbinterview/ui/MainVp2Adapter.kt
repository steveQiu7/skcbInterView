package com.example.skcbinterview.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class MainVp2Adapter(fa: FragmentActivity, list: List<Fragment>) : FragmentStateAdapter(fa) {

    private val mListFragment: List<Fragment> = list

    override fun getItemCount(): Int = mListFragment.size

    override fun createFragment(position: Int): Fragment = mListFragment[position]

}