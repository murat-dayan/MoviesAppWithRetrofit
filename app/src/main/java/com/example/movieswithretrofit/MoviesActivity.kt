package com.example.movieswithretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.movieswithretrofit.databinding.ActivityMoviesBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MoviesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMoviesBinding
    private lateinit var category: Categories
    private lateinit var mdi:MoviesDaoInterface
    private lateinit var moviesbyCategoryAdapter: MoviesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this, R.layout.activity_movies)



        category= intent.getSerializableExtra("category") as Categories

        binding.toolbarMoviesA.title="Movies : ${category.category_name}"
        setSupportActionBar(binding.toolbarMoviesA)

        binding.rvMoviesA.setHasFixedSize(true)
        binding.rvMoviesA.layoutManager= StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        getMoviesByCategory()
    }

    fun getMoviesByCategory(){

        mdi= ApiUtils.getMoviesDaoInterface()

        mdi.getMoviesByCategoryId(category.category_id).enqueue(object : Callback<MoviesRespond>{
            override fun onResponse(call: Call<MoviesRespond>?, response: Response<MoviesRespond>?) {
                if (response != null){
                    val movies= response.body().movies

                    for (m in movies){

                        moviesbyCategoryAdapter= MoviesAdapter(this@MoviesActivity, movies)
                        binding.rvMoviesA.adapter= moviesbyCategoryAdapter
                    }
                }
            }

            override fun onFailure(call: Call<MoviesRespond>?, t: Throwable?) {
                Toast.makeText(this@MoviesActivity,t?.localizedMessage, Toast.LENGTH_SHORT).show()

            }

        })


    }
}