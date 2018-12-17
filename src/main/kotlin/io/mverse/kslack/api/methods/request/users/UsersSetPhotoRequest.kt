package io.mverse.kslack.api.methods.request.users

import io.mverse.kslack.api.methods.SlackApiRequest
import java.io.File

/**
 * Set the user profile photo
 */


data class UsersSetPhotoRequest(

  /**
   * Authentication token. Requires scope: `users.profile:write`
   */
  override var token: String? = null,

  /**
   * File contents via `multipart/form-data`.
   */
  val image: File,

  /**
   * X coordinate of top-left corner of crop box
   */
  val cropX: Int? = null,

  /**
   * Y coordinate of top-left corner of crop box
   */
  val cropY: Int? = null,

  /**
   * Width/height of crop box (always square)
   */
  val cropW: Int? = null): SlackApiRequest
