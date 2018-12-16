package com.github.seratch.jslack.api.methods.request.groups

import com.github.seratch.jslack.api.methods.SlackApiRequest

data class GroupsCloseRequest(

  val token: String,
  val channel: String? = null): SlackApiRequest