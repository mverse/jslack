package com.github.seratch.jslack.common.http

import com.github.seratch.jslack.api.methods.SlackApiException
import com.github.seratch.jslack.common.json.GsonFactory
import okhttp3.FormBody
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.Response
import okio.Buffer
import org.slf4j.LoggerFactory

val log = LoggerFactory.getLogger(SlackHttpClient::class.java)

class SlackHttpClient {

  private val okHttpClient: OkHttpClient

  constructor() {
    this.okHttpClient = OkHttpClient.Builder().build()
  }

  constructor(okHttpClient: OkHttpClient) {
    this.okHttpClient = okHttpClient
  }

  fun postMultipart(url: String, token: String, multipartBody: MultipartBody): Response {
    val bearerHeaderValue = "Bearer $token"
    val request = Request.Builder().url(url).header("Authorization", bearerHeaderValue).post(multipartBody).build()
    return okHttpClient.newCall(request).execute()
  }

  fun postForm(url: String, formBody: FormBody): Response {
    val request = Request.Builder().url(url).post(formBody).build()
    return okHttpClient.newCall(request).execute()
  }

  fun postFormWithBearerHeader(url: String, token: String, formBody: FormBody): Response {
    val bearerHeaderValue = "Bearer $token"
    val request = Request.Builder().url(url).header("Authorization", bearerHeaderValue).post(formBody).build()
    return okHttpClient.newCall(request).execute()
  }

  fun postJsonPostRequest(url: String, obj: Any): Response {
    val body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), toJsonString(obj))
    val request = Request.Builder().url(url).post(body).build()
    return okHttpClient.newCall(request).execute()
  }

  fun delete(requestBuilder: Request.Builder): Response {
    return okHttpClient.newCall(requestBuilder.method("DELETE", null).build()).execute()
  }

  private fun toJsonString(obj: Any): String {
    val gson = GsonFactory.createSnakeCase()
    return gson.toJson(obj)
  }

  companion object {

    fun debugLog(response: Response, body: String?) {
      if (log.isDebugEnabled) {
        val requestBody = Buffer()
        response.request().body()?.writeTo(requestBody)
        var textRequestBody: String? = null
        try {
          textRequestBody = requestBody.buffer().readUtf8()
        } catch (e: Exception) {
          log.debug("Failed to read request body because {}, error: {}", e.message, e.javaClass.canonicalName)
        }

        log.debug("\n[Request URL]\n{} {}\n" +
            "[Specified Request Headers]\n{}" +
            "[Request Body]\n{}\n\n" +
            "Content-Type: {}\n" +
            "Content Length: {}\n" +
            "\n" +
            "[Response Status]\n{} {}\n" +
            "[Response Headers]\n{}" +
            "[Response Body]\n{}\n",
            response.request().method(),
            response.request().url(),
            response.request().headers(),
            textRequestBody,
            response.request().body()?.contentType(),
            response.request().body()?.contentLength(),
            response.code(),
            response.message(),
            response.headers(),
            body)
      }
    }

    fun <T> buildJsonResponse(response: Response, clazz: Class<T>): T {
      if (response.code() == 200) {
        val body = response.body()?.string()
        debugLog(response, body)
        return GsonFactory.createSnakeCase().fromJson(body, clazz)
      } else {
        val body = response.body()?.string() ?: ""
        throw SlackApiException(response, body)
      }
    }
  }
}
