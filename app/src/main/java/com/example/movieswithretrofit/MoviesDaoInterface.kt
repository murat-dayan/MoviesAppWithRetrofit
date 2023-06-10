package com.example.movieswithretrofit

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface MoviesDaoInterface {

    @GET("tum_kategoriler.php")
    fun getCategories(): Call<CategoriesRespond>

    @POST("filmler_by_kategori_id.php")
    @FormUrlEncoded
    fun getMoviesByCategoryId(@Field("kategori_id") category_id:Int): Call<MoviesRespond>

}