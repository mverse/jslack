package io.mverse.kslack.common.json

import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import io.mverse.kslack.api.interactive.DialogCancellationPayload
import io.mverse.kslack.api.interactive.DialogSubmissionPayload
import io.mverse.kslack.api.interactive.DialogSuggestionPayload
import io.mverse.kslack.api.interactive.DynamicMenuPayload
import io.mverse.kslack.api.interactive.InteractiveMessagePayload
import io.mverse.kslack.api.interactive.InteractivePayload
import io.mverse.kslack.api.interactive.OptionsPayload

object GsonFactory {
  fun createSnakeCase(): Gson {
    return GsonBuilder()
        .configureForSlack()
        .create()
  }
}

fun GsonBuilder.configureForSlack(): GsonBuilder =
    setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        .registerTypeAdapterFactory(RuntimeTypeAdapterFactory.of(InteractivePayload::class.java, "type")
            .registerSubtype(DialogSubmissionPayload::class.java, "dialog_submission")
            .registerSubtype(DialogCancellationPayload::class.java, "dialog_cancellation")
            .registerSubtype(InteractiveMessagePayload::class.java, "interactive_message"))
        .registerTypeAdapterFactory(RuntimeTypeAdapterFactory.of(OptionsPayload::class.java, "type")
            .registerSubtype(DialogSuggestionPayload::class.java, "dialog_suggestion")
            .registerSubtype(DynamicMenuPayload::class.java, "interactive_message"))

inline fun <reified T> Gson.fromJson(input: String): T = this.fromJson(input, T::class.java)

