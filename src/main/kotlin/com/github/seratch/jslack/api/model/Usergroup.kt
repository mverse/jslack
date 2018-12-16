package com.github.seratch.jslack.api.model

import com.google.gson.annotations.SerializedName

/**
 * https://api.slack.com/types/usergroup
 */
data class Usergroup(

  val id: String? = null,
  val teamId: String? = null,
  @SerializedName("is_usergroup")
  val isUsergroup: Boolean = false,
  val name: String? = null,
  val description: String? = null,
  val handle: String? = null,
  @SerializedName("is_external")
  val isExternal: Boolean = false,
  val dateCreate: Int? = null,
  val dateUpdate: Int? = null,
  val dateDelete: Int? = null,
  val autoType: String? = null,
  val createdBy: String? = null,
  val updatedBy: String? = null,
  val deletedBy: String? = null,
  val prefs: Prefs? = null,
  val users: List<String>? = null,
  val userCount: Int? = null) {

  data class Prefs(
    val channels: List<String>? = null,
    val groups: List<String>? = null)

}