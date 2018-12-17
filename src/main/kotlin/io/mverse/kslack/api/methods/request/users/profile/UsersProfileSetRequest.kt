package io.mverse.kslack.api.methods.request.users.profile

import io.mverse.kslack.api.methods.SlackApiRequest
import io.mverse.kslack.api.model.User

data class UsersProfileSetRequest(

  /**
   * Authentication token. Requires scope: `users.profile:write`
   */
  override var token: String? = null,

  /**
   * ID of user to change. This argument may only be specified by team admins on paid teams.
   */
  val user: String? = null,

  /**
   * Collection of key:value pairs presented as a URL-encoded JSON hash.
   */
  val profile: User.Profile? = null,

  /**
   * Name of a single key to set. Usable only if profile is not passed.
   */
  val name: String?= null,

  /**
   * Value to set a single key to. Usable only if profile is not passed.
   */
  val value: String? = null): SlackApiRequest