package io.mverse.kslack.api.methods.request.groups

import io.mverse.kslack.api.methods.SlackApiRequest

data class GroupsCloseRequest(

  val token: String,
  val channel: String? = null): SlackApiRequest