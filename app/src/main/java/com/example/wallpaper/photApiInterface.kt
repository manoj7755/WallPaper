package com.example.wallpaper

import com.example.photoapi.PhotoModel
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface photApiInterface  {

    @Headers("Authorization: 563492ad6f91700001000001be50e17bdfa7474b85f24e7d823f5e8b")

    @GET("search")
    fun getPhto(@Query("query")query:String, @Query("par_page")par_page:String): Call<PhotoModel>
    //    563492ad6f91700001000001be50e17bdfa7474b85f24e7d823f5e8b
    companion object{
        val BASE_URL = "https://api.pexels.com/v1/"
        fun PhotoCreat():photApiInterface{
            val photoRetrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(
                GsonConverterFactory.create()).build()
            return photoRetrofit.create(photApiInterface::class.java)
        }
    }
}