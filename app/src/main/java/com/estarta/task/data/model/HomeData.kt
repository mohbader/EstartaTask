package com.estarta.task.data.model

import com.google.gson.annotations.SerializedName

data class HomeData(

    @SerializedName("results")
    val resultItemsList: List<Item>
)
