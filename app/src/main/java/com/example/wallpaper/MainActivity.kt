package com.example.wallpaper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.photoapi.PhotoModel
import com.example.wallpaper.Adapter.popularRecycleViewAdapter
import com.example.wallpaper.Adapter.recycleviewOfTextSearchAdapter
import com.example.wallpaper.ModelClass.textsSearch
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        requestListener("nature")
       var textSearchData =  ArrayList<textsSearch>().apply {
            add(textsSearch("Nature"))
            add(textsSearch("Mountain"))
            add(textsSearch("flower"))
            add(textsSearch("yellow"))
            add(textsSearch("green"))
            add(textsSearch("flower"))
            add(textsSearch("yellow"))
            add(textsSearch("green"))
        }

        recycleViewOfTextSearch.apply {
            layoutManager = LinearLayoutManager(this@MainActivity,LinearLayoutManager.HORIZONTAL,false)
            adapter= recycleviewOfTextSearchAdapter(this@MainActivity,textSearchData)
        }

        search_btn_original.setOnClickListener {
            val searchQuery = search_Btn.text.toString()
            requestListener(searchQuery)
        }



    }

    fun requestListener(query:String){
        photApiInterface.PhotoCreat().getPhto(query,"10").enqueue(object :Callback<PhotoModel>{
            override fun onResponse(call: Call<PhotoModel>, response: Response<PhotoModel>) {
                recycleOfPopular.layoutManager = LinearLayoutManager(this@MainActivity,LinearLayoutManager.HORIZONTAL,false)
                recycleOfPopular.adapter = popularRecycleViewAdapter(this@MainActivity,response.body()!!.photos)
            }

            override fun onFailure(call: Call<PhotoModel>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Network Error", Toast.LENGTH_SHORT).show()
            }

        })

        // write Here
        val
        val repository = wallpaperRepository()
        val viewModelactivity= ViewModelProvider(this,)
    }
}