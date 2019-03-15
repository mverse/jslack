package io.mverse.kslack.common.http

import okhttp3.FormBody
import okhttp3.MultipartBody
import okhttp3.Request
import okhttp3.Response

interface HttpClient<R> {
  fun postMultipart(url: String, token: String, multipartBody: MultipartBody): Response
  fun postForm(url: String, formBody: FormBody): Response
  fun postFormWithBearerHeader(url: String, token: String, formBody: FormBody): Response
  fun postJsonPostRequest(url: String, obj: Any): Response
  fun delete(requestBuilder: Request.Builder): Response
}