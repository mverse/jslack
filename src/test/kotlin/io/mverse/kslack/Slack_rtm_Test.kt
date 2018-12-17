//package io.mverse.kslack
//
//import io.mverse.kslack.api.rtm.RTMClient
//import io.mverse.kslack.api.rtm.RTMMessageHandler
//import com.google.gson.JsonObject
//import com.google.gson.JsonParser
//import lombok.extern.slf4j.Slf4j
//import org.junit.Test
//
//import javax.websocket.DeploymentException
//import java.io.IOException
//
//@Slf4j
//class Slack_rtm_Test {
//
//  internal var slack = Slack()
//
//  @Test
//  @Throws(Exception::class)
//  fun rtmStart() {
//    val jsonParser = JsonParser()
//    val token = System.getenv(Constants.SLACK_BOT_USER_TEST_OAUTH_ACCESS_TOKEN)
//    slack.rtmStart(token, use=({ rtm -> verifyRTMClientBehavior(jsonParser, rtm) })
//  }
//
//  @Test
//  @Throws(Exception::class)
//  fun rtmConnect() {
//    val jsonParser = JsonParser()
//    val token = System.getenv(Constants.SLACK_BOT_USER_TEST_OAUTH_ACCESS_TOKEN)
//    slack.rtmConnect(token, use=({ rtm -> verifyRTMClientBehavior(jsonParser, rtm) })
//  }
//
//  @Throws(IOException::class, DeploymentException::class, InterruptedException::class)
//  private fun verifyRTMClientBehavior(jsonParser: JsonParser, rtm: RTMClient) {
//    val handler1 = { message ->
//      val json = jsonParser.parse(message).getAsJsonObject()
//      if (json.get("type") != null) {
//        log.info("Handled type: {}", json.get("type").getAsString())
//      }
//    }
//    val handler2 = { message -> log.info("Hello!") }
//    rtm.addMessageHandler(handler1)
//    rtm.addMessageHandler(handler1)
//    rtm.addMessageHandler(handler2)
//    rtm.connect()
//
//    Thread.sleep(SLEEP_MILLIS.toLong())
//    // Try anything on the channel...
//
//    rtm.removeMessageHandler(handler2)
//
//    Thread.sleep(SLEEP_MILLIS.toLong())
//    // Try anything on the channel...
//  }
//
//  companion object {
//
//    //    private static int SLEEP_MILLIS = 10000;
//    private val SLEEP_MILLIS = 100
//  }
//}