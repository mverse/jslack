package io.mverse.kslack.api.model

import com.google.gson.annotations.SerializedName

data class TeamIcon(

  @SerializedName("image_34")
  val image34: String? = null,
  @SerializedName("image_44")
  val image44: String? = null,
  @SerializedName("image_68")
  val image68: String? = null,
  @SerializedName("image_88")
  val image88: String? = null,
  @SerializedName("image_102")
  val image102: String? = null,
  @SerializedName("image_132")
  val image132: String? = null,

  val isImageDefault: Boolean = false)
