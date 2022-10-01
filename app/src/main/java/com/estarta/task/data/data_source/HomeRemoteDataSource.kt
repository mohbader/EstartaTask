package com.estarta.task.data.data_source

import com.estarta.task.data.model.HomeData
import retrofit2.http.GET

interface HomeRemoteDataSource {

    @GET("default/dynamodb-writer")
    fun getHomeData(): HomeData
}