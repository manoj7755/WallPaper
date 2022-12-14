package com.example.wallpaper.Api

import com.example.wallpaper.Api.photApiInterface


class wallpaperRepository(val photApiInterface: photApiInterface) {

    fun getPhototR(query:String,par_page:String ="",total_results:String ="",color:String = "") = photApiInterface.getPhto(query,par_page,total_results,color)

}