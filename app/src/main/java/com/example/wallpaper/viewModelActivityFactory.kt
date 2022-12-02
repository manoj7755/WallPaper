package com.example.wallpaper

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.wallpaper.Adapter.viewModelActivity

class viewModelActivityFactory(private val repository: wallpaperRepository):ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        return viewModelActivity(repository) as T
    }


}