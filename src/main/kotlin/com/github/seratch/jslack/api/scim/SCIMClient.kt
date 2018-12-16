package com.github.seratch.jslack.api.scim

import com.github.seratch.jslack.api.methods.SlackApiException
import com.github.seratch.jslack.api.scim.request.UsersDeleteRequest
import com.github.seratch.jslack.api.scim.response.UsersDeleteResponse

import java.io.IOException

/**
 * [API Methods](https://api.slack.com/scim)
 */
interface SCIMClient {

  fun setEndpointUrlPrefix(endpointUrlPrefix: String)


  fun delete(req: UsersDeleteRequest): UsersDeleteResponse
}
