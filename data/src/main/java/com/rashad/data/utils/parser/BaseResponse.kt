package com.rashad.data.utils.parser

import androidx.annotation.Keep
import java.io.Serializable

@Keep
class BaseResponse<T>(
  val Status: Int,
  val code: Int,
  val msg: String,
  val Errors: Array<T>,
  val data: T?,
) : Serializable
