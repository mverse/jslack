package io.mverse.kslack.api.model

import com.google.gson.annotations.SerializedName

/**
 * https://api.slack.com/types/file
 */


data class File(

  val id: String? = null,
  val created: Int? = null,
  val timestamp: Int? = null,
  val name: String? = null,
  val title: String? = null,
  val mimetype: String? = null,
  val filetype: String? = null,
  val prettyType: String? = null,
  val user: String? = null,
  val mode: String? = null,
  val isEditable: Boolean = false,
  @SerializedName("is_external")
  val isExternal: Boolean = false,
  val externalType: String? = null,
  val username: String? = null,
  val size: Int? = null,
  val urlPrivate: String? = null,
  val urlPrivateDownload: String? = null,

  @SerializedName("thumb_64")
  val thumb64: String? = null,
  @SerializedName("thumb_80")
  val thumb80: String? = null,

  @SerializedName("thumb_360")
  val thumb360: String? = null,
  @SerializedName("thumb_360_gif")
  val thumb360Gif: String? = null,
  @SerializedName("thumb_360_w")
  val thumb360Width: String? = null,
  @SerializedName("thumb_360_h")
  val thumb360Height: String? = null,

  @SerializedName("thumb_480")
  val thumb480: String? = null,
  @SerializedName("thumb_480_w")
  val thumb480Width: String? = null,
  @SerializedName("thumb_480_h")
  val thumb480Height: String? = null,

  @SerializedName("thumb_160")
  val thumb160: String? = null,

  val permalink: String? = null,
  val permalinkPublic: String? = null,

  val editLink: String? = null,

  val preview: String? = null,
  val previewHighlight: String? = null,

  val lines: Int? = null,
  val linesMoe: Int? = null,

  @SerializedName("is_public")
  var isPublic: Boolean = false,

  val isPublicUrlShared: Boolean = false,
  val isDisplayAsBot: Boolean = false,

  val channels: List<String>? = null,
  val groups: List<String>? = null,
  val ims: List<String>? = null,
  val initialComment: FileComment? = null,
  val numStars: Int? = null,

  @SerializedName("is_starred")
  val isStarred: Boolean = false,

  val pinnedTo: List<String>? = null,
  val reactions: List<Reaction>? = null,
  val commentsCount: Int? = null)