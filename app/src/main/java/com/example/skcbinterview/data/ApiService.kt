package com.example.skcbinterview.data

import com.example.skcbinterview.data.model.DataMuseumIntroduction
import com.example.skcbinterview.data.model.DataPlant
import retrofit2.http.GET

interface ApiService {

    /**
     * 取得館區簡介
     */
    @GET("/api/v1/dataset/5a0e5fbb-72f8-41c6-908e-2fb25eff9b8a?scope=resourceAquire")
    suspend fun getApiMuseumIntroduction():BaseResponse<DataMuseumIntroduction>

    /**
     * 取得資物資料
     */
    @GET("/api/v1/dataset/f18de02f-b6c9-47c0-8cda-50efad621c14?scope=resourceAquire")
    suspend fun getApiPlantData():BaseResponse<DataPlant>
}