package io.mverse.kslack.api.methods.response.migration

import io.mverse.kslack.api.methods.SlackApiResponse

data class MigrationExchangeResponse (

    override val ok: Boolean = false,
    override val warning: String? = null,
    override val error: String? = null,

    /**
   * The workspace/team ID containing the mapped users
   */
  val teamId: String? = null,

    /**
   * The enterprise grid organization ID containing the workspace/team.
   */
  val enterpriseId: String? = null,

    /**
   * A list of User IDs that cannot be mapped or found
   */
  val invalidUserIds: List<String>? = null,

    /**
   * A mapping of provided user IDs with mapped user IDs
   */
  val userIdMap: Map<String, String>? = null): SlackApiResponse