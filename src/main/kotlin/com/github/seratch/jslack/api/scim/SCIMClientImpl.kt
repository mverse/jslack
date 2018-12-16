package com.github.seratch.jslack.api.scim

import com.github.seratch.jslack.api.methods.SlackApiException
import com.github.seratch.jslack.api.scim.request.UsersDeleteRequest
import com.github.seratch.jslack.api.scim.response.UsersDeleteResponse
import com.github.seratch.jslack.common.http.SlackHttpClient
import okhttp3.Request
import java.io.IOException

class SCIMClientImpl(private val slackHttpClient: SlackHttpClient) : SCIMClient {

  private var endpointUrlPrefix = "https://api.slack.com/scim/v1/Users"

  override fun setEndpointUrlPrefix(endpointUrlPrefix: String) {
    this.endpointUrlPrefix = endpointUrlPrefix
  }


  override fun delete(req: UsersDeleteRequest): UsersDeleteResponse {
    val request = Request.Builder().url(endpointUrlPrefix + "/" + req.id).addHeader("Authorization", "Bearer " + req.token!!)
    return doDeleteRequest(request, UsersDeleteResponse::class.java)
  }


  private fun <T> doDeleteRequest(requestBuilder: Request.Builder, clazz: Class<T>): T {
    val response = slackHttpClient.delete(requestBuilder)
    return if (response.isSuccessful()) {
      SlackHttpClient.buildJsonResponse(response, clazz)
    } else {
      throw SlackApiException(response, response.body()?.string())
    }
  }
}
