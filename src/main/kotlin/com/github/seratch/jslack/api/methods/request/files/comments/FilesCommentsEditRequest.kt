package com.github.seratch.jslack.api.methods.request.files.comments

import com.github.seratch.jslack.api.methods.SlackApiRequest

data class FilesCommentsEditRequest(

  /**
   * Authentication token. Requires scope: `files:write:user`
   */
  val token: String,

  /**
   * File containing the comment to edit.
   */
  val file: String? = null,

  /**
   * The comment to edit.
   */
  val id: String? = null,

  /**
   * Text of the comment to edit.
   */
  val comment: String? = null): SlackApiRequest