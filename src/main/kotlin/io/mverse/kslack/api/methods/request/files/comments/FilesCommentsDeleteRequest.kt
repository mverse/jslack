package io.mverse.kslack.api.methods.request.files.comments

import io.mverse.kslack.api.methods.SlackApiRequest

data class FilesCommentsDeleteRequest(

  /**
   * Authentication token. Requires scope: `files:write:user`
   */
  val token: String,

  /**
   * File to delete a comment from.
   */
  val file: String? = null,

  /**
   * The comment to delete.
   */
  val id: String? = null): SlackApiRequest