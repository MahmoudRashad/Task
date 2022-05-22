package com.rashad.data.features.auth.responses

import com.google.gson.annotations.SerializedName


class CategoryRemote (
    @SerializedName("id") val id: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("description")  val description: String?,
    @SerializedName("image")    val image: String?,
    @SerializedName("slug")    val slug: String?,
    @SerializedName("children")    val children: List<ChildrensCategoryRemote>?,
    @SerializedName("circle_icon")    val circleIcon: String?,
    @SerializedName("disable_shipping")   val disableShipping: String?,

){
    class ChildrensCategoryRemote(
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