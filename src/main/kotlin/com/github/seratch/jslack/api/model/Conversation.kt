package com.github.seratch.jslack.api.model

import com.google.gson.annotations.SerializedName

/**
 * Represents a [conversation](https://api.slack.com/types/conversation)
 * as used with the `conversations` API
 *
 *
 *
 * @see https://api.slack.com/docs/conversations-api
 */


data class Conversation(

  val id: String? = null,
  val name: String? = null,
  val created: String? = null,
  val creator: String? = null,
  val unlinked: Int? = null,
  @SerializedName("name_normalized")
  val nameNormalized: String? = null,
  @SerializedName("pending_shared")
  val pendingShared: List<String>? = null,
  @SerializedName("last_read")
  val lastRead: String? = null,
  val topic: Topic? = null,
  val purpose: Purpose? = null,
  @SerializedName("previous_names")
  val previousNames: List<String>? = null,
  @SerializedName("num_members")
  val numOfMembers: Int? = null,
  val members: List<String>? = null,
  val latest: Latest? = null,
  val locale: String? = null,
  @SerializedName("unreadCount")
  val unreadCount: Int? = null,
  @SerializedName("unreadCountDisplay")
  val unreadCountDisplay: Int? = null,

  @SerializedName("is_channel")
  val isChannel: Boolean = false,
  @SerializedName("is_group")
  val isGroup: Boolean = false,
  @SerializedName("is_im")
  val isIm: Boolean = false,
  @SerializedName("is_archived")
  val isArchived: Boolean = false,
  @SerializedName("is_general")
  val isGeneral: Boolean = false,
  @SerializedName("is_read_only")
  val isReadOnly: Boolean = false,
  @SerializedName("is_shared")
  val isShared: Boolean = false,
  @SerializedName("is_ext_shared")
  val isExtShared: Boolean = false,
  @SerializedName("is_org_shared")
  val isOrgShared: Boolean = false,
  @SerializedName("is_pending_ext_shared")
  val isPendingExtShared: Boolean = false,
  @SerializedName("is_member")
  val isMember: Boolean = false,
  @SerializedName("is_private")
  val isPrivate: Boolean = false,
  @SerializedName("is_mpim")
  val isMpim: Boolean = false)
