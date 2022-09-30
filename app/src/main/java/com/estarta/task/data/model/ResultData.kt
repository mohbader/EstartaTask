package com.estarta.task.data.model

import com.google.gson.annotations.SerializedName

data class ResultData(

    @SerializedName("results")
    val resultItemsList:List<Item>
)
