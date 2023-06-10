package com.example.movieswithretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieswithretrofit.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mdi:MoviesDaoInterface
    private lateinit var categoriesAdapter: CategoriesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.toolbarMA.title= "Categories"
        setSupportActionBar(binding.toolbarMA)

        binding.rvMA.setHasFixedSize(true)
        binding.rvMA.layoutManager= LinearLayoutManager(this)

        getCategories()



    }

    fun getCategories(){

        mdi= ApiUtils.getMoviesDaoInterface()

        mdi.getCategories().enqueue(object : Callback<CategoriesRespond>{
            override fun onResponse(call: Call<CategoriesRespond>?, response: Response<CategoriesRespond>?) {
                if (response != null){
                    val categories= response.body().categories

                    for (c in categories){


                        categoriesAdapter= CategoriesAdapter(this@MainActivity, categories)
                        binding.rvMA.adapter= categoriesAdapter

                    }
                }
            }

            override fun onFailure(call: Call<CategoriesRespond>?, t: Throwable?) {
                Toast.makeText(this@MainActivity,t?.localizedMessage, Toast.LENGTH_SHORT).show()
            }

        })


    }




}