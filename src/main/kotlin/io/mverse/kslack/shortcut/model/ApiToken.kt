package io.mverse.kslack.shortcut.model


inline class ApiToken(val value: String) {
  companion object {
    val DEFAULT = ApiToken("")
  }
}
