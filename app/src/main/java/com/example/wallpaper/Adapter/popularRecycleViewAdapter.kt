package com.example.wallpaper.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.photoapi.Photos
import com.example.wallpaper.Activity.Set_DownloadActivity
import com.example.wallpaper.R
import kotlinx.android.synthetic.main.item_of_recycleveiw.view.*

class popularRecycleViewAdapter(val context: Context, val popularData: ArrayList<Photos>) :RecyclerView.Adapter<popularRecycleViewAdapter.ViewHolder>(){
    class
    ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        val popularImg = itemView.popularImg
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_of_recycleveiw,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//      holder.popularImg.setImageResource(popularData[position].)
        Glide.with(context).load(popularData[position].src!!.portrait).into(holder.popularImg)
//        Glide.with(context).load(popularData).into(holder.popularImg)
//        Glide.with(context).load(popularData).into(holder.popularImg)
    holder.itemView.popularImg.setOnClickListener {
        val intent = Intent(context,Set_DownloadActivity::class.java)
        intent.putExtra("Url",popularData[position].src!!.portrait!!)
         context.startActivity(intent)

        
    }

    }

    override fun getItemCount(): Int {
     return popularData.size
    }
}