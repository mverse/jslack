package com.github.seratch.jslack.api.methods.request.files

import com.github.seratch.jslack.api.methods.SlackApiRequest

data class FilesSharedPublicURLRequest(

  /**
   * Authentication token. Requires scope: `files:write:user`
   */
  val token: String,

  /**
   * File to share
   */
  val file: String? = null): SlackApiRequest