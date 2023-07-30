package com.example.skcbinterview.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.skcbinterview.data.model.DataMuseumIntroduction
import com.example.skcbinterview.databinding.FragmentMainBinding
import com.example.skcbinterview.ui.rvAdapter.ParkRvAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainFragment : Fragment() {

    companion object {
        val TAG = MainFragment::class.java.simpleName.toString()
        fun newInstance() = MainFragment()
    }

    private var mFragMainFragmentBinding: FragmentMainBinding? = null
    private val mVB get() = mFragMainFragmentBinding!!
    private val mMainViewModel by activityViewModels<MainViewModel>()

    private lateinit var mAdapter: ParkRvAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mFragMainFragmentBinding = FragmentMainBinding.inflate(layoutInflater)
        mVB.viewModel = mMainViewModel
        mVB.lifecycleOwner = this
        return mVB.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
        initView()
    }

    private fun initData() {
        CoroutineScope(Dispatchers.IO).launch { mMainViewModel.apiGetMuseumIntroduction() }
    }

    private fun initView() {
        mAdapter = ParkRvAdapter(mMainViewModel)
        mVB.rvMainAcPark.adapter = mAdapter
        mVB.rvMainAcPark.layoutManager = LinearLayoutManager(context)
        mMainViewModel.listParkInfo.observe(this, Observer<ArrayList<DataMuseumIntroduction.DataMuseumIntroductionInfo>> {
            mAdapter.list = it
            mAdapter.notifyDataSetChanged()
        })
    }

    override fun onDestroy() {
        mFragMainFragmentBinding = null
        super.onDestroy()
    }

}