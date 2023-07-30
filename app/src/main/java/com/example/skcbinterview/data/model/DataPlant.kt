package com.example.skcbinterview.data.model

import com.google.gson.annotations.SerializedName

data class DataPlant(

    @SerializedName("limit")
    val limit:Int,

    @SerializedName("offset")
    val offset:Int,

    @SerializedName("count")
    val count:Int,

    @SerializedName("sort")
    val sort:String,

    @SerializedName("results")
    val listResults:ArrayList<DataPlantInfo>

) {

    data class DataPlantInfo(

        @SerializedName("\uFEFFF_Name_Ch")
        val fNameCh:String,

        @SerializedName("F_Name_En")
        val fNameEn:String,

        //別名
        @SerializedName("F_AlsoKnown")
        val fAlsoKnow:String,

        //簡介
        @SerializedName("F_Brief")
        val fBrief:String,

        //辨認方式
        @SerializedName("F_Feature")
        val fFeature:String,

        //功能性
        @SerializedName("F_Function＆Application")
        val fFunctionAndApplication:String,

        //最後更新
        @SerializedName("F_Update")
        val fUpdate:String,

        @SerializedName("F_Pic01_URL")
        val fPic01Url:String
    )

}