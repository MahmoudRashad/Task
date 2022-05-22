package com.rashad.domain.authentication.models

import com.google.gson.annotations.SerializedName

class CategoryModel (
    @SerializedName("id") val id: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("description")  val description: String?,
    @SerializedName("image")    val image: String?,
    @SerializedName("slug")    val slug: String?,
    @SerializedName("children")    val children: List<ChildrensCategoryModel>?,
    @SerializedName("circle_icon")    val circleIcon: String?,
    @SerializedName("disable_shipping")   val disableShipping: String?,

    ){
    class ChildrensCategoryModel(
        @SerializedName("id") val id: Int?,
        @SerializedName("name") val name: String?,
        @SerializedName("description") val description: String?,
        @SerializedName("image") val image: String?,
        @SerializedName("slug") val slug: String?,
        @SerializedName("children") val children: String?,
        @SerializedName("circle_icon") val circleIcon: String?,
        @SerializedName("disable_shipping") val disableShipping: String?,
    )
}