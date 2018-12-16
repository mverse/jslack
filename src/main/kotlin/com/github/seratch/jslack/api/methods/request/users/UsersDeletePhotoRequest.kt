package com.github.seratch.jslack.api.methods.request.users

import com.github.seratch.jslack.api.methods.SlackApiRequest

/**
 * Delete the user profile photo
 */


data class UsersDeletePhotoRequest(

  /**
   * Authentication token. Requires scope: `users.profile:write`
   */
  val token: String): SlackApiRequest
