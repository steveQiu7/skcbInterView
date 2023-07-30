package com.example.skcbinterview.ui

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.skcbinterview.databinding.FragmentParkBinding
import com.example.skcbinterview.ui.rvAdapter.PlantRvAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ParkFragment : Fragment() {

    companion object {
        val TAG = ParkFragment::class.java.simpleName
        fun newInstance() = ParkFragment()
    }

    private var mFragmentParkBinding: FragmentParkBinding? = null
    private val mVB get() = mFragmentParkBinding!!
    private val mMainViewModel by activityViewModels<MainViewModel>()

    private lateinit var mAdapter: PlantRvAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mFragmentParkBinding = FragmentParkBinding.inflate(layoutInflater)
        mVB.viewModel = mMainViewModel
        mVB.lifecycleOwner = this
        return mVB.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
        initView()
    }

    private fun initData(){
        CoroutineScope(Dispatchers.IO).launch { mMainViewModel.apiGetPlantData() }
    }

    private fun initView() {
        mVB.tvFragParkInfo.movementMethod = ScrollingMovementMethod.getInstance()

        mAdapter = PlantRvAdapter(mMainViewModel)
        mVB.rvFragParkPlant.adapter = mAdapter
        mVB.rvFragParkPlant.layoutManager = LinearLayoutManager(context)
        mMainViewModel.listPlantInfo.observe(this){
            mAdapter.list = it
            mAdapter.notifyDataSetChanged()
        }
    }

    override fun onDestroy() {
        mFragmentParkBinding = null
        super.onDestroy()
    }
}