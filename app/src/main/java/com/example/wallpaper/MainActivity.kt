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
import com.example.wallpaper.Adapter.viewModelActivity
import com.example.wallpaper.ModelClass.textsSearch
import com.example.wallpaper.photApiInterface.Companion.PhotoCreat
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var viewModelactivity:viewModelActivity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var textSearchData = ArrayList<textsSearch>().apply {
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
            layoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
            adapter = recycleviewOfTextSearchAdapter(this@MainActivity, textSearchData)
        }

        search_btn_original.setOnClickListener {
            val searchQuery = search_Btn.text.toString()
            val page = "10"
            if(!searchQuery.isEmpty() && !page.isEmpty()){
                requestListener(searchQuery,page)
            }else{
                Toast.makeText(this, "Search Something", Toast.LENGTH_SHORT).show()
            }

        }
// here write
        // write Here
        val repository = wallpaperRepository(photApiInterface.PhotoCreat())
        viewModelactivity = ViewModelProvider(
            this,
            viewModelActivityFactory(repository)
        )[viewModelActivity::class.java]
        viewModelactivity.data.observe(this){

            recycleOfPopular.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
            recycleOfPopular.adapter = popularRecycleViewAdapter(this,it.photos)
        }

        requestListener("nature","10")
    }

    fun requestListener(query:String, par_page:String){

        viewModelactivity.getPhotoV(query,par_page)
      }


    }
