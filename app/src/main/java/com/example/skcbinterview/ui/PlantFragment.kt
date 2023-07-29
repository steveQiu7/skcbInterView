package com.example.skcbinterview.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.skcbinterview.databinding.FragmentPlantBinding

class PlantFragment : Fragment() {

    companion object {
        val TAG = PlantFragment::class.java.simpleName
        fun newInstance() = PlantFragment()
    }

    private var mFragmentPlantBinding: FragmentPlantBinding? = null
    private val mVB get() = mFragmentPlantBinding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mFragmentPlantBinding = FragmentPlantBinding.inflate(layoutInflater)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroy() {
        mFragmentPlantBinding = null
        super.onDestroy()
    }

}