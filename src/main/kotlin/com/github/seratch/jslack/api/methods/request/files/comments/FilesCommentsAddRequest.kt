package com.github.seratch.jslack.api.methods.request.files.comments

import com.github.seratch.jslack.api.methods.SlackApiRequest

data class FilesCommentsAddRequest(

  /**
   * Authentication token. Requires scope: `files:write:user`
   */
  val token: String,

  /**
   * File to add a comment to.
   */
  val file: String? = null,

  /**
   * Text of the comment to add.
   */
  val comment: String? = null): SlackApiRequest