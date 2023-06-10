package com.example.movieswithretrofit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class MoviesRespond(

    @SerializedName("filmler")
    @Expose
    var movies: List<Movies>,

    @SerializedName("success")
    @Expose
    var success:Int

){

}
