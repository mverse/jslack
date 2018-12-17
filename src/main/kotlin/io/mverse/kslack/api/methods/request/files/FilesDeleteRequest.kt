package io.mverse.kslack.api.methods.request.files

import io.mverse.kslack.api.methods.SlackApiRequest

data class FilesDeleteRequest(

  /**
   * Authentication token. Requires scope: `files:write:user`
   */
  override var token: String? = null,

  /**
   * ID of file to delete.
   */
  val file: String? = null): SlackApiRequest