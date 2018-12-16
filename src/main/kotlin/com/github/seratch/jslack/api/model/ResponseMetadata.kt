package com.github.seratch.jslack.api.model

import com.google.gson.annotations.SerializedName

/**
 * An attribute included within the response of the newest Slack APIs which contains a `next_cursor`
 * value.  By using this value as a cursor parameter in a subsequent request, along with limit, you may
 * navigate through the collection page by virtual page.
 */

data class ResponseMetadata(
  @SerializedName("next_cursor")
  val nextCursor: String? = null)
