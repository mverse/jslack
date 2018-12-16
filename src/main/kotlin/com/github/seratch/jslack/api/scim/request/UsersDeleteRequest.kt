package com.github.seratch.jslack.api.scim.request

import com.github.seratch.jslack.api.methods.SlackApiRequest

data class UsersDeleteRequest(
  val token: String? = null,
  val id: String? = null): SlackApiRequest
