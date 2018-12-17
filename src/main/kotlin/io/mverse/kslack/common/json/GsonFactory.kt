package io.mverse.kslack.common.json

import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import io.mverse.kslack.api.interactive.DialogSubmissionPayload
import io.mverse.kslack.api.interactive.InteractiveMessagePayload
import io.mverse.kslack.api.interactive.InteractivePayload

object GsonFactory {
  fun createSnakeCase(): Gson {
    return GsonBuilder()
        .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        .registerTypeAdapterFactory(RuntimeTypeAdapterFactory.of(InteractivePayload::class.java, "type")
            .registerSubtype(DialogSubmissionPayload::class.java, "dialog_submission")
            .registerSubtype(InteractiveMessagePayload::class.java, "dialog_submission"))
        .create()
  }
}
