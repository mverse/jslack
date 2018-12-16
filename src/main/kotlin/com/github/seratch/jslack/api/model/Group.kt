package com.github.seratch.jslack.api.model

import com.google.gson.annotations.SerializedName

/**
 * https://api.slack.com/types/group
 */


data class Group(
  val id: String? = null,
  val name: String? = null,
  @SerializedName("is_group")
  val isGroup: Boolean = false,
  val created: Int? = null,
  val creator: String? = null,
  @SerializedName("is_archived")
  val isArchived: Boolean = false,
  @SerializedName("is_mpim")
  val isMpim: Boolean = false,
  val members: List<String>? = null,
  val topic: Topic? = null,
  val purpose: Purpose? = null,
  val lastRead: String? = null,
  val latest: Latest? = null,
  val unreadCount: Int? = null,
  val unreadCountDisplay: Int? = null)