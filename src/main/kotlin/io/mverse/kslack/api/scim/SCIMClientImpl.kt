package io.mverse.kslack.api.scim

import io.ktor.client.HttpClient
import io.ktor.client.request.delete
import io.ktor.client.request.header
import io.ktor.http.takeFrom
import io.mverse.kslack.api.methods.SlackApiException
import io.mverse.kslack.api.scim.request.UsersDeleteRequest
import io.mverse.kslack.api.scim.response.UsersDeleteResponse
import okhttp3.Request

class SCIMClientImpl(private val httpClient: HttpClient) : SCIMClient {

  private var endpointUrlPrefix = "https://api.slack.com/scim/v1/Users"

  override fun setEndpointUrlPrefix(endpointUrlPrefix: String) {
    this.endpointUrlPrefix = endpointUrlPrefix
  }

  override suspend fun delete(req: UsersDeleteRequest): UsersDeleteResponse {
    return httpClient.delete {
      url.takeFrom(endpointUrlPrefix + "/" + req.id)
      header("Authorization", "Bearer ${req.token}")
    }
  }
}
