package io.mverse.kslack.api.methods.request.groups

import io.mverse.kslack.api.methods.SlackApiRequest

data class GroupsCloseRequest(

  override var token: String? = null,
  val channel: String? = null): SlackApiRequest