package com.example.movieswithretrofit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CategoriesRespond(
    @SerializedName("kategoriler")
    @Expose
    var categories: List<Categories>,

    @SerializedName("success")
    @Expose
    var success:Int

) {
}