package com.example.skcbinterview.data.model

import com.google.gson.annotations.SerializedName

data class DataMuseumIntroduction(

    @SerializedName("limit")
    val limit: Int,

    @SerializedName("offset")
    val offset: Int,

    @SerializedName("count")
    val count: Int,

    @SerializedName("sort")
    val sort: String,

    @SerializedName("results")
    val listResults: ArrayList<DataMuseumIntroductionInfo>

) {
    data class DataMuseumIntroductionInfo(
        @SerializedName("_id")
        val id: Int = 0,

        @SerializedName("e_name")
        val eName: String = "",

        @SerializedName("e_pic_url")
        val ePicUrl: String = "",

        @SerializedName("e_info")
        val eInfo: String = "",

        @SerializedName("e_memo")
        val eMemo: String = "",

        @SerializedName("e_category")
        val eCategory: String = "",

        @SerializedName("e_url")
        val eUrl: String = ""

    )
}