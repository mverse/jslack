package com.github.seratch.jslack.api.model

data class Login(

  val userId: String? = null,
  val username: String? = null,
  val dateFirst: Int? = null,
  val dateLast: Int? = null,
  val count: Int? = null,
  val ip: String? = null,
  val userAgent: String? = null,
  val isp: String? = null,
  val country: String? = null,
  val region: String? = null)
