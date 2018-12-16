package com.github.seratch.jslack.api.methods.request.files

import com.github.seratch.jslack.api.methods.SlackApiRequest

data class FilesInfoRequest(

  /**
   * Authentication token. Requires scope: `files:read`
   */
  val token: String,

  /**
   * Specify a file by providing its ID.
   */
  val file: String? = null,

  val count: Int? = null,

  val page: Int? = null): SlackApiRequest