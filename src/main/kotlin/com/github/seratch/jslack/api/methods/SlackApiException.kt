package com.github.seratch.jslack.api.methods

import com.github.seratch.jslack.common.http.SlackHttpClient
import com.github.seratch.jslack.common.json.GsonFactory
import okhttp3.Response
import org.slf4j.LoggerFactory

val log = LoggerFactory.getLogger(SlackHttpClient::class.java)

class SlackApiException(val response: Response, val responseBody: String? = null) : Exception() {
  val error: SlackApiErrorResponse?

  init {
    var parsedErrorResponse: SlackApiErrorResponse? = null
    try {
      parsedErrorResponse = GsonFactory.createSnakeCase().fromJson(responseBody, SlackApiErrorResponse::class.java)
    } catch (e: Exception) {
      if (log.isDebugEnabled) {
        val responseToPrint = if (responseBody != null && responseBody.length > 1000) responseBody.subSequence(0, 1000).toString() + " ..." else responseBody
        log.debug("Failed to parse the error response body: {}", responseToPrint)
      }
    }

    this.error = parsedErrorResponse
  }
}
