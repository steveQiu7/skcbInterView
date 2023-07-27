package com.example.skcbinterview.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception


class ApiRepository(private val apiClient: ApiClient) {

    private fun <T : Any> execute(function: suspend () -> T): Flow<ResourceViewModel<T>> = flow {
        emit(ResourceViewModel.loading(data = null))
        try {
            emit(ResourceViewModel.success(function()))
        } catch (e: Exception) {
            emit(ResourceViewModel.error(data = null,e = e))
        }
    }


}