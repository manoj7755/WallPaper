package com.example.wallpaper.Adapter

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.photoapi.PhotoModel
import com.example.wallpaper.wallpaperRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class viewModelActivity(val wallpaperRepository: wallpaperRepository): ViewModel(){
     var  data  = MutableLiveData<PhotoModel>()

    fun getPhotoV(query:String,par_page:String){
         wallpaperRepository.getPhototR(query,par_page).enqueue(object :Callback<PhotoModel>{
             override fun onResponse(call: Call<PhotoModel>, response: Response<PhotoModel>) {
                  data.postValue(response.body())


             }

             override fun onFailure(call: Call<PhotoModel>, t: Throwable) {

             }

         })
    }
}