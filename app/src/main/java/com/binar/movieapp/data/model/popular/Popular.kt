package com.binar.movieapp.data.model.popular

import com.google.gson.annotations.SerializedName


data class Popular(
    @SerializedName("page")
    val page: Int? = null,
    @SerializedName("results")
    val results: ArrayList<PopularItem>? = null
)