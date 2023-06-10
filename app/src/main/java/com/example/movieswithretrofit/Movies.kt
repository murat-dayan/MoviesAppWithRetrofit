package com.example.movieswithretrofit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Movies(
    @SerializedName("film_id")
    @Expose
    var movie_id:Int,

    @SerializedName("film_ad")
    @Expose
    var movie_name:String,

    @SerializedName("film_yil")
    @Expose
    var movie_year:Int,

    @SerializedName("film_resim")
    @Expose
    var movie_image:String,

    @SerializedName("kategori")
    @Expose
    var category: Categories,

    @SerializedName("yonetmen")
    @Expose
    var director:Directors

) : java.io.Serializable{}
