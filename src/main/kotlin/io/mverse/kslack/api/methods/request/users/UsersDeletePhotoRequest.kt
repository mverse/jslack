package io.mverse.kslack.api.methods.request.users

import io.mverse.kslack.api.methods.SlackApiRequest

/**
 * Delete the user profile photo
 */


data class UsersDeletePhotoRequest(

  /**
   * Authentication token. Requires scope: `users.profile:write`
   */
  val token: String): SlackApiRequest
