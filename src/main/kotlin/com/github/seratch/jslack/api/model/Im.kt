package com.github.seratch.jslack.api.model

import com.google.gson.annotations.SerializedName

/**
 * https://api.slack.com/types/im
 */

data class Im(

  val id: String? = null,
  @SerializedName("is_im")
  val isIm: Boolean = false,
  val user: String? = null,
  val created: Int? = null,
  @SerializedName("is_user_deleted")
  val isUser_deleted: Boolean = false)
