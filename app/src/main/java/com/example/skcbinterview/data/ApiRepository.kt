package com.example.skcbinterview.data

import com.example.skcbinterview.data.model.DataMuseumIntroduction
import com.example.skcbinterview.data.model.DataPlant
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception


class ApiRepository(private val apiService: ApiService) {

    companion object {
        fun getInstance(apiService: ApiService): ApiRepository {
            return ApiRepository(apiService)
        }
    }

    private fun <T : Any> execute(function: suspend () -> T): Flow<ResourceStatus<T>> = flow {
        emit(ResourceStatus.Loading)
        try {
            emit(ResourceStatus.Success(function()))
        } catch (e: Exception) {
            emit(ResourceStatus.Error(e))
        }
    }

    fun getApiMuseumIntroduction(): Flow<ResourceStatus<BaseResponse<DataMuseumIntroduction>>> = execute {
        apiService.getApiMuseumIntroduction()
    }

    fun getApiPlantData(): Flow<ResourceStatus<BaseResponse<DataPlant>>> = execute {
        apiService.getApiPlantData()
    }

}