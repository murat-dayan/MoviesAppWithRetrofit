package com.example.movieswithretrofit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Categories(

    @SerializedName("kategori_id")
    @Expose
    var category_id:Int,

    @SerializedName("kategori_ad")
    @Expose
    var category_name:String
) : java.io.Serializable {
}