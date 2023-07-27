package com.example.skcbinterview.data

sealed class ResourceStatus<out T:Any> {

    class Success<out T:Any>(val data:T):ResourceStatus<T>()
    class Error(val exception: Throwable) : ResourceStatus<Nothing>()
    object Loading : ResourceStatus<Nothing>()

//        fun <T> success(data:T):ResourceStatus<T> = ResourceStatus(status = Status.SUCCESS,e = null, data = data)
//        fun <T> error(e:Exception?,data:T?):ResourceStatus<T> = ResourceStatus(status = Status.ERROR, e = e,data = data)
//        fun <T> loading(data:T?):ResourceStatus<T> = ResourceStatus(status = Status.LOADING,e = null, data = data)

}