package com.example.photoapi

import com.google.gson.annotations.SerializedName


data class PhotoModel (

  @SerializedName("page"          ) var page         : Int?              = null,
  @SerializedName("per_page"      ) var perPage      : Int?              = null,
  @SerializedName("photos"        ) var photos       : ArrayList<Photos> = arrayListOf(),
  @SerializedName("total_results" ) var totalResults : Int?              = null,
  @SerializedName("next_page"     ) var nextPage     : String?           = null

)