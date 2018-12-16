package com.github.seratch.jslack.api.model

import com.google.gson.annotations.SerializedName

data class Icon(
  @SerializedName("image_48")
  var image48: String? = null)
