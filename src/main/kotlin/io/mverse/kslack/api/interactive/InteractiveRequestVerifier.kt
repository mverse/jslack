package io.mverse.kslack.api.interactive

import java.lang.IllegalStateException
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec

/**
 * Retrieve the X-Slack-Request-Timestamp header on the HTTP request, and the body of the request.
 * Concatenate the version number, the timestamp, and the body of the request to form a basestring.
 * Use a colon as the delimiter between the three elements. For example, v0:123456789:command=/weather&text=94070.
 * The version number right now is always v0.
 *
 * With the help of HMAC SHA256 implemented in your favorite programming, hash the above basestring, using the Slack Signing Secret as the key.
 * Compare this computed signature to the X-Slack-Signature header on the request.
 */
class InteractiveRequestVerifier(val version:String = "v0", signingSecret: String) {

  val sha256 = Mac.getInstance("HmacSHA256");

  init {
    sha256.init(SecretKeySpec(signingSecret.toByteArray(), "HmacSHA256"))
  }

  fun verifyRequest(signedValue: String, timestamp: String, payload: String) {
    val concatenatedString = "$version:$timestamp:$payload"
    val hashed = sha256.doFinal(concatenatedString.toByteArray())
    val calculatedSignature = hashed.map { String.format("%02X", it) }.joinToString("")
    if (signedValue.toLowerCase() != calculatedSignature) {
      throw IllegalStateException("Signature failed validation")
    }
  }
}
