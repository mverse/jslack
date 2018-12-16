package com.github.seratch.jslack.api.methods.request.migration

import com.github.seratch.jslack.api.methods.SlackApiRequest

/**
 * For Enterprise Grid workspaces, map local user IDs to global user IDs
 */


data class MigrationExchangeRequest(

  /**
   * Authentication token. Requires scope: `tokens.basic`
   */
  val token: String,

  /**
   * Specify `true` to convert `W` global user IDs to workspace-specific `U` IDs. Defaults to `false`.
   */
  val isToOld: Boolean = false,

  /**
   * A comma-separated list of user ids, up to 400 per request
   */
  val users: List<String>? = null): SlackApiRequest