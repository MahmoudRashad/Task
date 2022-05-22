package com.rashad.data.extension

import android.net.Uri
import java.io.File

//fun File.imageFileToPart(bodyName: String = "files[]") =
//  MultipartBody.Part.createFormData(
//    bodyName, path, asRequestBody("image/*".toMediaTypeOrNull())
//  )
//
//fun Uri.imageUriToPart(bodyName: String = "files[]") =
//  File(path!!).imageFileToPart(bodyName)
//
//fun File.imageFilePathToPart(bodyName: String = "files[]"): MultipartBody.Part {
//  return MultipartBody.Part.createFormData(
//    bodyName, path, asRequestBody("image/*".toMediaTypeOrNull())
//  )
//}
//
//fun String.imagePathToPart(bodyName: String = "files[]") =
//  File(this).imageFilePathToPart(bodyName)
//
//fun File.videoFileToPart(bodyName: String = "files[]") =
//  MultipartBody.Part.createFormData(
//    bodyName, name, asRequestBody("video/*".toMediaTypeOrNull()))
//
//fun Uri.videoUriToPart(bodyName: String = "files[]") = File(path ?: "").imageFileToPart(bodyName)
//
//fun File.videoFilePathToPart(bodyName: String = "files[]"): MultipartBody.Part {
//  return MultipartBody.Part.createFormData(
//    bodyName, path, asRequestBody("video/*".toMediaTypeOrNull())
//  )
//}
//
//fun String.videoPathToPart(bodyName: String = "files[]") =
//  File(this).videoFilePathToPart(bodyName)