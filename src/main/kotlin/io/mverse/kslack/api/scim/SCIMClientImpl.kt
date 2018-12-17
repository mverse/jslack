package io.mverse.kslack.api.scim

import io.mverse.kslack.api.methods.SlackApiException
import io.mverse.kslack.api.scim.request.UsersDeleteRequest
import io.mverse.kslack.api.scim.response.UsersDeleteResponse
import io.mverse.kslack.common.http.SlackHttpClient
import okhttp3.Request

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
