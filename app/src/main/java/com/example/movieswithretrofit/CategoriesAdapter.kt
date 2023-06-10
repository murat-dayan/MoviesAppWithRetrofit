package com.example.movieswithretrofit

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class CategoriesAdapter(private val mContext:Context, private val categoriesList:List<Categories>)
    : RecyclerView.Adapter<CategoriesAdapter.CardViewCategoriesHolder>()
{

    inner class CardViewCategoriesHolder(view:View): RecyclerView.ViewHolder(view){
        var cardViewCategories: CardView
        var cardViewCategoryName: TextView

        init {
            cardViewCategories= view.findViewById(R.id.cardViewCategoriesId)
            cardViewCategoryName= view.findViewById(R.id.cardViewCategoryNameId)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewCategoriesHolder {
        val design= LayoutInflater.from(mContext).inflate(R.layout.cardview_categories,parent,false)
        return CardViewCategoriesHolder(design)
    }

    override fun getItemCount(): Int {
        return categoriesList.size
    }

    override fun onBindViewHolder(holder: CardViewCategoriesHolder, position: Int) {
        val category= categoriesList.get(position)

        holder.cardViewCategoryName.setText(category.category_name)

        holder.cardViewCategories.setOnClickListener {

            val intent= Intent(mContext, MoviesActivity::class.java)
            intent.putExtra("category", category)
            mContext.startActivity(intent)

        }

    }


}