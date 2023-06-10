package com.example.movieswithretrofit

class ApiUtils {

    companion object{
        val BASE_URL="http://kasimadalan.pe.hu/filmler/"

        fun getMoviesDaoInterface() : MoviesDaoInterface{
            return RetrofitClient.getClient(BASE_URL).create(MoviesDaoInterface::class.java)
        }

    }

}