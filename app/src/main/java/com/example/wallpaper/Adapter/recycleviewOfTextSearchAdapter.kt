package com.example.wallpaper.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wallpaper.Activity.MainActivity
import com.example.wallpaper.ModelClass.textsSearch
import com.example.wallpaper.R
import kotlinx.android.synthetic.main.row_tem_of_text_search.view.*

class recycleviewOfTextSearchAdapter(val context: Context,val textSearchData:ArrayList<textsSearch>): RecyclerView.Adapter<recycleviewOfTextSearchAdapter.ViewHolder>(){
    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
  val textSearch = itemView.textSearch
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.row_tem_of_text_search,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
   holder.textSearch.text = textSearchData[position].textSearch
        holder.textSearch.setOnClickListener {
            (context as MainActivity).requestListener("Dog","10")
        }

    }

    override fun getItemCount(): Int {
     return textSearchData.size
    }
}