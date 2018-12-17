package io.mverse.kslack.api.model

import com.google.gson.annotations.SerializedName

data class MatchedItem(
  val type: String? = null,
  val channel: Channel? = null,
  val user: String? = null,
  val username: String? = null,
  val ts: String? = null,
  val text: String? = null,
  val permalink: String? = null,
  val name: String,
  val preview: String? = null,
  val timestamp: String? = null,
  @SerializedName("thumb_360")
  val thumb360: String? = null,
  @SerializedName("url_private")
  val urlprivate: String? = null,

  @SerializedName("previous_2")
  val previous2: OtherItem? = null,
  val previous: OtherItem? = null,
  val next: OtherItem? = null,
  @SerializedName("next_2")
  val next2: OtherItem? = null) {

  data class Channel(
      val id: String? = null,
      val name: String? = null)


  data class OtherItem(
      val user: String? = null,
      val username: String? = null,
      val ts: String? = null,
      val text: String? = null,
      val type: String? = null)

}

