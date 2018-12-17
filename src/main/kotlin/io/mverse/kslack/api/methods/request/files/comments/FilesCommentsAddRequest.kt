package io.mverse.kslack.api.methods.request.files.comments

import io.mverse.kslack.api.methods.SlackApiRequest

data class FilesCommentsAddRequest(

  /**
   * Authentication token. Requires scope: `files:write:user`
   */
  override var token: String? = null,

  /**
   * File to add a comment to.
   */
  val file: String? = null,

  /**
   * Text of the comment to add.
   */
  val comment: String? = null): SlackApiRequest