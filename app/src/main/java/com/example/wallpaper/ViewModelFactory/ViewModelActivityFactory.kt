package com.example.wallpaper.ViewModelFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.wallpaper.ActivityViewModel.viewModelActivity
import com.example.wallpaper.Api.wallpaperRepository

class viewModelActivityFactory(private val repository: wallpaperRepository):ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        return viewModelActivity(repository) as T
    }


}