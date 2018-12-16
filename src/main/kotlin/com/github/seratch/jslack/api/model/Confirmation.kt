package com.github.seratch.jslack.api.model

data class Confirmation(
  val title: String? = null,
  val text: String? = null,
  val ok_text:String = OKAY,
  var dismiss_text:String = DISMISS) {
  companion object {
    val OKAY = "Okay"
    val DISMISS = "Cancel"
  }
}
