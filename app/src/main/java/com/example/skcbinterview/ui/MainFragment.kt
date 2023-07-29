package com.example.skcbinterview.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.skcbinterview.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    companion object {
        val TAG = MainFragment::class.java.simpleName.toString()
        fun newInstance() = MainFragment()
    }

    private var mFragMainFragmentBinding: FragmentMainBinding? = null
    private val mVB get() = mFragMainFragmentBinding!!
    private val mMainViewModel by activityViewModels<MainViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mFragMainFragmentBinding = FragmentMainBinding.inflate(layoutInflater)
        return mVB.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mVB.tvFragMain.setOnClickListener {
            mMainViewModel.setIntPageControl(1)
        }
    }

    override fun onDestroy() {
        mFragMainFragmentBinding = null
        super.onDestroy()
    }

}