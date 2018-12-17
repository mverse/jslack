package io.mverse.kslack.api.methods.response.bots

import io.mverse.kslack.api.methods.SlackApiResponse

data class BotsInfoResponse (
    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null,
    val bot: Bot? = null): SlackApiResponse

data class Bot(
    val id: String? = null,
    val appId: String? = null,
    val userId: String? = null,
    val name: String? = null,
    val isDeleted: Boolean = false,
    val updated: Int? = null,
    val icons: Icons? = null)

data class Icons(
  val image36: String? = null,
  val image48: String? = null,
  val image72: String? = null)