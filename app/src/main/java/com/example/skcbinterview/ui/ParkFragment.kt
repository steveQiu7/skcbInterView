package com.example.skcbinterview.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.skcbinterview.databinding.FragmentParkBinding

class ParkFragment : Fragment() {

    companion object {
        val TAG = ParkFragment::class.java.simpleName
        fun newInstance() = ParkFragment()
    }

    private var mFragmentParkBinding: FragmentParkBinding? = null
    private val mVB get() = mFragmentParkBinding!!
    private val mMainViewModel by activityViewModels<MainViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mFragmentParkBinding = FragmentParkBinding.inflate(layoutInflater)
        return mVB.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mVB.tvFragPark.setOnClickListener {
            mMainViewModel.setIntPageControl(2)
        }
    }

    override fun onDestroy() {
        mFragmentParkBinding = null
        super.onDestroy()
    }
}