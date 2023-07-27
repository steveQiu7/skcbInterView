package com.example.skcbinterview.data

import com.google.gson.annotations.SerializedName

data class BaseResponse<T> (
     @SerializedName("result")
     val dataBean:T
)