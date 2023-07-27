package com.example.skcbinterview.data

class ResourceViewModel<out T>(val status:Status,val e:Exception?,val data:T?) {
    companion object{
        fun <T> success(data:T):ResourceViewModel<T> = ResourceViewModel(status = Status.SUCCESS,e = null, data = data)
        fun <T> error(e:Exception?,data:T?):ResourceViewModel<T> = ResourceViewModel(status = Status.ERROR, e = e,data = data)
        fun <T> loading(data:T?):ResourceViewModel<T> = ResourceViewModel(status = Status.LOADING,e = null, data = data)
    }
}