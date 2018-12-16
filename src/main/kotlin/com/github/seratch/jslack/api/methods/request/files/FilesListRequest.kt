package com.github.seratch.jslack.api.methods.request.files

import com.github.seratch.jslack.api.methods.SlackApiRequest

data class FilesListRequest(

  /**
   * Authentication token. Requires scope: `files:read`
   */
  val token: String,

  /**
   * Filter files created by a single user.
   */
  val user: String? = null,

  /**
   * Filter files appearing in a specific channel, indicated by its ID.
   */
  val channel: String? = null,

  /**
   * Filter files created after this timestamp (inclusive).
   */
  val tsFrom: String? = null,

  /**
   * Filter files created before this timestamp (inclusive).
   */
  val tsTo: String? = null,

  /**
   * Filter files by type:\n\n* `all` - All files
   *
   *
   * `spaces` - Posts\n* `snippets` - Snippets
   * `images` - Image files
   * `gdocs` - Google docs
   * `zips` - Zip files
   * `pdfs` - PDF files
   *
   *
   * You can pass multiple values in the types argument, like `types=spaces,snippets`.
   * The default value is `all`, which does not filter the list.
   */
  val types: List<String>? = null,

  val count: Int? = null,

  val page: Int? = null): SlackApiRequest