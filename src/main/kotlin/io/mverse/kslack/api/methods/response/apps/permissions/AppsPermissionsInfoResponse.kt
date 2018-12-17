package io.mverse.kslack.api.methods.response.apps.permissions

import io.mverse.kslack.api.methods.SlackApiResponse

data class AppsPermissionsInfoResponse (
    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null,
    val info: Info? = null): SlackApiResponse

data class Info(
  val team: Permissions? = null,
  val channel: Permissions? = null,
  val group: Permissions? = null,
  val mpim: Permissions? = null,
  val im: Permissions? = null,
  val appHome: Permissions? = null)

data class Permissions(
  val scopes: List<String>? = null,
  val resources: Resources? = null)

data class Resources(
  val ids: List<String>? = null,
  val isWildcard: Boolean = false,
  val excludedIds: List<String>? = null)