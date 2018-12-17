package io.mverse.kslack.api.methods.request.files

import io.mverse.kslack.api.methods.SlackApiRequest

data class FilesRevokePublicURLRequest(

  /**
   * Authentication token. Requires scope: `files:write:user`
   */
  override var token: String? = null,

  /**
   * File to revoke
   */
  val file: String? = null): SlackApiRequest