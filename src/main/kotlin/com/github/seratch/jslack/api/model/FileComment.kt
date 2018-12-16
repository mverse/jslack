package com.github.seratch.jslack.api.model

/**
 * https://api.slack.com/methods/files.comments.add
 */


data class FileComment(

  val id: String? = null,
  val created: Int? = null,
  val timestamp: Int? = null,
  val user: String? = null,
  val comment: String? = null,
  val channel: String? = null)