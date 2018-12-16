package com.github.seratch.jslack

import com.github.seratch.jslack.api.model.Attachment
import com.github.seratch.jslack.api.model.Field
import com.github.seratch.jslack.api.webhook.Payload
import org.junit.Test
import org.slf4j.LoggerFactory
import java.io.IOException

val log = LoggerFactory.getLogger(Slack_incomingWebhooks_Test::class.java)

class Slack_incomingWebhooks_Test {

  internal var slack = Slack.instance

  @Test
  @Throws(IOException::class)
  fun incomingWebhook() {
    // String url = "https://hooks.slack.com/services/T00000000/B00000000/XXXXXXXXXXXXXXXXXXXXXXXX";
    val url = System.getenv("SLACK_WEBHOOK_TEST_URL")
        ?: throw IllegalStateException("Environment variable SLACK_WEBHOOK_TEST_URL must be defined")

    val field1 = Field(
        title = "Long Title",
        value = "Long Value........................................................",
        isValueShortEnough = (false))

    val field2 = Field(
        title = "Short Title",
        value = "Short Value",
        isValueShortEnough = true)

    val attachment = Attachment(
        text = "This is an *attachment*.",
        authorName = "Smiling Imp",
        color = "#36a64f",
        fallback = "Required plain-text summary of the attachment.",
        title = "Slack API Documentation",
        titleLink = "https://api.slack.com/",
        footer = "footer",
        fields = listOf(field1, field1, field2, field2),
        mrkdwnIn = listOf("text"))

    val payload = Payload(
        channel = "#random",
        text = "Hello World!",
        iconEmoji = ":smile_cat:",
        username = "jSlack",
        attachments = listOf(attachment))

    val response = slack.send(url, payload)
    log.info(response.body)
  }
}
