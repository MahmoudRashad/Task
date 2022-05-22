package com.rashad.data.features.auth.responses

import com.google.gson.annotations.SerializedName


class OptionsChildRemote (
    @SerializedName("id") val id: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("description")  val description: String?,
    @SerializedName("slug")    val slug: String?,
    @SerializedName("parent")    val parent:Int ?,
    @SerializedName("list")    val list: Boolean?,
    @SerializedName("type")   val type: String  ?,
    @SerializedName("value")   val value: String?,
    @SerializedName("other_value")   val otherValue: String?,
    @SerializedName("options")   val options :List<OptionRemote>?,

){
    class OptionRemote(
        @SerializedName("id") val id: Int?,
        @SerializedName("name") val name: String?,
        @SerializedName("slug") val slug: String?,
        @SerializedName("parent") val parent: Int?,
        @SerializedName("child") val child: Boolean?,
        )
}