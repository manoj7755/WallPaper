package com.example.wallpaper.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wallpaper.ActivityViewModel.viewModelActivity
import com.example.wallpaper.Adapter.*
import com.example.wallpaper.ModelClass.textsSearch
import com.example.wallpaper.R
import com.example.wallpaper.ViewModelFactory.viewModelActivityFactory
import com.example.wallpaper.Api.photApiInterface
import com.example.wallpaper.Api.wallpaperRepository
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var viewModelactivity: viewModelActivity
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
      menu_btn.setOnClickListener {
        val intent = Intent(this, SearchActivity::class.java)
          startActivity(intent)
      }
        search_btn_original.setOnClickListener {
            val searchQuery = search_Btn.text.toString()
//            val page = "10"
            if(!searchQuery.isEmpty()){
                val intent = Intent(this, SearchActivity::class.java)
                intent.putExtra("searchQuery",searchQuery)
//                intent.putExtra("page",page)
                startActivity(intent)
//                requestListener(searchQuery,page)
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

//            recycleOfPopular.layoutManager = LinearLayoutManager(this@MainActivity,LinearLayoutManager.HORIZONTAL,false)l
//            recycleOfPopular.adapter = popularRecycleViewAdapter(this,it.photos)
             recycleOfPopular.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
            recycleOfPopular.adapter =popularRecycleViewAdapter(this, it.photos)


            recycleViewOfTextSearchContent.layoutManager = GridLayoutManager(this,2)
            recycleViewOfTextSearchContent.adapter =  recycleViewAdapterOfContent(this, it.photos)


            Log.d("Manoj","${it.totalResults}")
        }

        requestListener("nature","30")
    }

    fun requestListener(query:String, par_page:String){

        viewModelactivity.getPhotoV(query,par_page)
      }


    }
