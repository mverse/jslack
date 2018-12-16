package com.github.seratch.jslack.api.model

import com.google.gson.annotations.SerializedName

data class Channel(

  val id: String,
  val name: String,
  val created: Int? = null,
  val creator: String? = null,
  @SerializedName("is_archived")
  val isArchived: Boolean = false,
  @SerializedName("is_member")
  val isMember: Boolean = false,
  @SerializedName("is_general")
  val isGeneral: Boolean = false,
  val lastRead: String? = null,
  val latest: Latest? = null,
  val unreadCount: Int? = null,
  val unreadCountDisplay: Int? = null,
  val members: List<String>? = null,
  val topic: Topic? = null,
  val purpose: Purpose? = null)
