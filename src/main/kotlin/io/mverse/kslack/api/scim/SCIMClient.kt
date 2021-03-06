package io.mverse.kslack.api.scim

import io.mverse.kslack.api.methods.SlackApiException
import io.mverse.kslack.api.scim.request.UsersDeleteRequest
import io.mverse.kslack.api.scim.response.UsersDeleteResponse

/**
 * [API Methods](https://api.slack.com/scim)
 */
interface SCIMClient {

  fun setEndpointUrlPrefix(endpointUrlPrefix: String)


  fun delete(req: UsersDeleteRequest): UsersDeleteResponse
}
