package com.example.movieswithretrofit

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class MoviesAdapter(private val mContext:Context, private val moviesList: List<Movies>)
    :RecyclerView.Adapter<MoviesAdapter.CardViewMoviesHolder>()
{

    inner class CardViewMoviesHolder(view: View): RecyclerView.ViewHolder(view){
        var cardViewMovies: CardView
        var cardViewMovieName: TextView
        var cardViewImage: ImageView

        init {
            cardViewMovies= view.findViewById(R.id.cardViewMoviesId)
            cardViewMovieName= view.findViewById(R.id.cardViewMovieNameId)
            cardViewImage= view.findViewById(R.id.cardViewMovieImageId)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesAdapter.CardViewMoviesHolder {
        val design= LayoutInflater.from(mContext).inflate(R.layout.cardview_movies,parent,false)
        return CardViewMoviesHolder(design)
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }

    override fun onBindViewHolder(holder: MoviesAdapter.CardViewMoviesHolder, position: Int) {
        val movie= moviesList.get(position)

        val url = "http://kasimadalan.pe.hu/filmler/resimler/${movie.movie_image}"
        Picasso.get().load(url).into (holder.cardViewImage)


        holder.cardViewMovieName.setText(movie.movie_name)

        holder.cardViewMovies.setOnClickListener {

            val intent= Intent(mContext, DetailActivity::class.java)
            intent.putExtra("movie", movie)
            mContext.startActivity(intent)
        }

    }
}