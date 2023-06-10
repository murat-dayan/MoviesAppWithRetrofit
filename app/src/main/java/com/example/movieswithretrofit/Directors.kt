package com.example.movieswithretrofit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Directors(
    @SerializedName("yonetmen_id")
    @Expose
    var director_id:Int,

    @SerializedName("yonetmen_ad")
    @Expose
    var director_name:String


) : java.io.Serializable{}
