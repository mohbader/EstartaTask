package com.estarta.task.data.model


import com.google.gson.annotations.SerializedName
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Item(

    @SerializedName("created_at")
    val createdAt: String? = null,

    @SerializedName("image_ids")
    val imageIds: List<String?>? = null,

    @SerializedName("image_urls")
    val imageUrls: List<String?>? = null,

    @SerializedName("image_urls_thumbnails")
    val imageUrlsThumbnails: List<String?>? = null,

    @SerializedName("name")
    val name: String? = null,

    @SerializedName("price")
    val price: String? = null,

    @SerializedName("uid")
    val uid: String? = null

) : Parcelable