package io.mverse.kslack.api.methods

import io.mverse.kslack.common.http.SlackHttpClient
import io.mverse.kslack.common.json.GsonFactory
import okhttp3.Response
import org.slf4j.LoggerFactory

val log = LoggerFactory.getLogger(SlackHttpClient::class.java)

class SlackApiException(val response: Response, val responseBody: String? = null) : Exception() {
  val error: io.mverse.kslack.api.methods.SlackApiErrorResponse?

  init {
    var parsedErrorResponse: io.mverse.kslack.api.methods.SlackApiErrorResponse? = null
    try {
      parsedErrorResponse = GsonFactory.createSnakeCase().fromJson(responseBody, io.mverse.kslack.api.methods.SlackApiErrorResponse::class.java)
    } catch (e: Exception) {
      if (log.isDebugEnabled) {
        val responseToPrint = if (responseBody != null && responseBody.length > 1000) responseBody.subSequence(0, 1000).toString() + " ..." else responseBody
        log.debug("Failed to parse the error response body: {}", responseToPrint)
      }
    }

    this.error = parsedErrorResponse
  }
}
