package io.mverse.kslack.api.model

/**
 * https://api.slack.com/methods/reactions.get
 */


data class Reaction(

  val name: String? = null,
  val count: Int? = null,
  val users: List<String>? = null)