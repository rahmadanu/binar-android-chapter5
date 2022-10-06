package com.binar.movieapp.data.model.search


import com.google.gson.annotations.SerializedName

data class Search(
    @SerializedName("page")
    val page: Int? = null,
    @SerializedName("results")
    val results: List<SearchItem?>? = null
)