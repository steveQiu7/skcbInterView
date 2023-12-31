package com.example.skcbinterview.ui

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.skcbinterview.R
import com.example.skcbinterview.data.ApiClient
import com.example.skcbinterview.data.ApiRepository
import com.example.skcbinterview.data.ViewModelFactory
import com.example.skcbinterview.databinding.ActivityMainBinding
import com.example.skcbinterview.ui.vp2Adapter.MainVp2Adapter

class MainActivity : AppCompatActivity() {

    private val mVB by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private lateinit var mMainViewModel: MainViewModel

    private var mListFrag: MutableList<Fragment> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mVB.root)
        setViewModel()
        setObserve()
        initView()
        initFragList()
        setViewPager()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                whenPageControl()
            }
        }
        return true
    }

    private fun initView() {
        setToolBar(mVB.includeTbShare.tbShareAc, true)
    }

    private fun setViewModel() {
        val apiClient = ApiClient.getInstance(this)
        val apiRepository = ApiRepository.getInstance(apiClient.apiClientService)
        mMainViewModel = ViewModelProvider(this, ViewModelFactory.getInstance(apiRepository))[MainViewModel::class.java]
    }

    private fun setObserve() {
        mMainViewModel.getIntPageControl().observe(this) {
            when (it) {
                1 -> {
                    mVB.vp2MainAc.setCurrentItem(1,false)
                    supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_arrow_back)
                    supportActionBar?.title = mMainViewModel.selectDataMuseumIntroductionInfo.value?.eName
                }
                2 -> {
                    mVB.vp2MainAc.setCurrentItem(2,false)
                    supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_arrow_back)
                    supportActionBar?.title = mMainViewModel.selectDataPlantInfo.value?.fNameCh
                }
            }
        }
    }

    private fun initFragList() {
        mListFrag.clear()
        mListFrag.add(MainFragment.newInstance())
        mListFrag.add(ParkFragment.newInstance())
        mListFrag.add(PlantFragment.newInstance())
    }

    private fun setViewPager() {
        mVB.vp2MainAc.offscreenPageLimit = mListFrag.size
        mVB.vp2MainAc.isUserInputEnabled = false
        mVB.vp2MainAc.adapter = MainVp2Adapter(this, mListFrag)
    }

    private fun whenPageControl() {
        when (mVB.vp2MainAc.currentItem) {
            1 -> {
                mVB.vp2MainAc.setCurrentItem(0,false)
                supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_dehaze)
                supportActionBar?.title = getString(R.string.main_ac_toolbar_title_taipei_zoo)
            }
            2 -> {
                mVB.vp2MainAc.setCurrentItem(1,false)
                supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_arrow_back)
                supportActionBar?.title = mMainViewModel.selectDataMuseumIntroductionInfo.value?.eName
            }
        }
    }

    private fun setToolBar(toolbar: Toolbar, isHomeBtnEnable: Boolean) {
        setSupportActionBar(toolbar)
        supportActionBar?.setHomeButtonEnabled(isHomeBtnEnable)
        supportActionBar?.setDisplayHomeAsUpEnabled(isHomeBtnEnable)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_dehaze)
        supportActionBar?.title = getString(R.string.main_ac_toolbar_title_taipei_zoo)
    }
}