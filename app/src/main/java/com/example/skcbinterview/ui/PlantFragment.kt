package com.example.skcbinterview.ui

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.skcbinterview.databinding.FragmentPlantBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PlantFragment : Fragment() {

    companion object {
        val TAG = PlantFragment::class.java.simpleName
        fun newInstance() = PlantFragment()
    }

    private var mFragmentPlantBinding: FragmentPlantBinding? = null
    private val mVB get() = mFragmentPlantBinding!!
    private val mMainViewModel by activityViewModels<MainViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mFragmentPlantBinding = FragmentPlantBinding.inflate(layoutInflater)
        mVB.viewModel = mMainViewModel
        mVB.lifecycleOwner = this
        return mVB.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroy() {
        mFragmentPlantBinding = null
        super.onDestroy()
    }

}