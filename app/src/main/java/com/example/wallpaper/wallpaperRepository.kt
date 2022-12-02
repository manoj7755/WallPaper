package com.example.wallpaper

import com.example.photoapi.PhotoModel
import retrofit2.Call
import retrofit2.http.Query

class wallpaperRepository(val photApiInterface: photApiInterface) {

    fun getPhototR(query:String,par_page:String):Call<PhotoModel>
    {
        return photApiInterface.getPhto(query,par_page)
    }
}