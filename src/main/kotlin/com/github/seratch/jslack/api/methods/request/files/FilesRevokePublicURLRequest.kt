package com.github.seratch.jslack.api.methods.request.files

import com.github.seratch.jslack.api.methods.SlackApiRequest

data class FilesRevokePublicURLRequest(

  /**
   * Authentication token. Requires scope: `files:write:user`
   */
  val token: String,

  /**
   * File to revoke
   */
  val file: String? = null): SlackApiRequest