package io.mverse.kslack.api.scim.request

import io.mverse.kslack.api.methods.SlackApiRequest

data class UsersDeleteRequest(
  override var token: String? = null,
  val id: String? = null): SlackApiRequest
