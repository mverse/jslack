package io.mverse.kslack.api.methods.request.files

import io.mverse.kslack.api.methods.SlackApiRequest

data class FilesSharedPublicURLRequest(

  /**
   * Authentication token. Requires scope: `files:write:user`
   */
  val token: String,

  /**
   * File to share
   */
  val file: String? = null): SlackApiRequest