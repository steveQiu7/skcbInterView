package com.example.skcbinterview.ui

import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.skcbinterview.MyApp
import com.example.skcbinterview.data.ApiRepository
import com.example.skcbinterview.data.ResourceStatus
import com.example.skcbinterview.data.model.DataMuseumIntroduction
import com.example.skcbinterview.data.model.DataPlant
import kotlinx.coroutines.launch

class MainViewModel(private val apiRepository: ApiRepository) : ViewModel() {

    var listParkInfo: MutableLiveData<ArrayList<DataMuseumIntroduction.DataMuseumIntroductionInfo>> = MutableLiveData()
    var listPlantInfo: MutableLiveData<ArrayList<DataPlant.DataPlantInfo>> = MutableLiveData()

    var selectDataMuseumIntroductionInfo: MutableLiveData<DataMuseumIntroduction.DataMuseumIntroductionInfo> = MutableLiveData()
    var selectDataPlantInfo: MutableLiveData<DataPlant.DataPlantInfo> = MutableLiveData()

    private var mIntPageControl: MutableLiveData<Int> = MutableLiveData()

    fun getIntPageControl(): MutableLiveData<Int> = this.mIntPageControl

    private fun setIntPageControl(iPosition: Int) {
        mIntPageControl.value = iPosition
    }

    suspend fun apiGetMuseumIntroduction() {
        apiRepository.getApiMuseumIntroduction().collect {
            when (it) {
                is ResourceStatus.Success -> {
                    listParkInfo.postValue(it.data.dataBean.listResults)
                }
                is ResourceStatus.Error -> {

                }
                is ResourceStatus.Loading -> {

                }
            }
        }
    }

    suspend fun apiGetPlantData() {
        apiRepository.getApiPlantData().collect() {
            when (it) {
                is ResourceStatus.Success -> {
                    listPlantInfo.postValue(it.data.dataBean.listResults)
                }
                is ResourceStatus.Error -> {

                }
                is ResourceStatus.Loading -> {

                }
            }
        }
    }

    fun selectParkItem(item: DataMuseumIntroduction.DataMuseumIntroductionInfo) = viewModelScope.launch {
        selectDataMuseumIntroductionInfo.value = item
        setIntPageControl(1)
    }

    fun selectPlantItem(item: DataPlant.DataPlantInfo) = viewModelScope.launch {
        selectDataPlantInfo.value = item
        setIntPageControl(2)
    }

    fun openUrl(url: String) {
        val intent = Intent()
        intent.action = Intent.ACTION_VIEW
        intent.data = Uri.parse(url)
        MyApp.getInstance().startActivity(intent)
    }
}