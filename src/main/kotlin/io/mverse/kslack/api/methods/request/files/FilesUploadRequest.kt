package io.mverse.kslack.api.methods.request.files

import io.mverse.kslack.api.methods.SlackApiRequest
import java.io.File

data class FilesUploadRequest(

  /**
   * Authentication token. Requires scope: `files:write:user`
   */
  override var token: String? = null,

  /**
   * File contents via `multipart/form-data`. If omitting this parameter, you must submit `content`.
   */
  val file: File? = null,

  /**
   * File contents via a POST variable. If omitting this parameter, you must provide a `file`.
   */
  val content: String? = null,

  /**
   * A [file type](/types/file#file_types) identifier.
   */
  val filetype: String? = null,

  /**
   * Filename of file.
   */
  val filename: String,

  /**
   * Title of file.
   */
  val title: String? = null,

  /**
   * Initial comment to add to file.
   */
  val initialComment: String? = null,

  /**
   * Comma-separated list of channel names or IDs where the file will be shared.
   */
  val channels: List<String>? = null): SlackApiRequest