package com.example.movieswithretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.movieswithretrofit.databinding.ActivityDetailBinding
import com.squareup.picasso.Picasso

class DetailActivity : AppCompatActivity() {

    private lateinit var binding:ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this, R.layout.activity_detail)

        val movie= intent.getSerializableExtra("movie") as Movies

        val url = "http://kasimadalan.pe.hu/filmler/resimler/${movie.movie_image}"
        Picasso.get().load(url).into (binding.imageViewMovieId)



        if(movie != null) {
            binding.textViewMovieNameId.setText(movie.movie_name)
            binding.textViewMovieYearId.setText((movie.movie_year).toString())
            if(movie.director != null) {
                binding.textViewDirectorNameId.setText(movie.director.director_name);
            } else {
                binding.textViewDirectorNameId.text= "alınamadı"
            }
        } else {
            // movie null
        }





    }
}