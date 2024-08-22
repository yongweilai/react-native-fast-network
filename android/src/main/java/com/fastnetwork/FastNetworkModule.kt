package com.fastnetwork

import com.facebook.react.bridge.*
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONArray
import org.json.JSONObject
import java.io.IOException

class FastNetworkModule(reactContext: ReactApplicationContext) :
    ReactContextBaseJavaModule(reactContext) {

    private val client: OkHttpClient = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val request = chain.request()
            println("Request URL: ${request.url}")
            chain.proceed(request)
        }
        .build()

    override fun getName() = NAME

    @ReactMethod
    fun get(url: String, token: String?, params: ReadableMap?, promise: Promise) {
        executeRequest(buildRequest(url, token, params, "GET", null), promise)
    }

    @ReactMethod
    fun post(url: String, data: ReadableMap?, token: String?, promise: Promise) {
        executeRequest(buildRequest(url, token, null, "POST", data?.toJsonRequestBody()), promise)
    }

    @ReactMethod
    fun put(url: String, data: ReadableMap?, token: String?, promise: Promise) {
        executeRequest(buildRequest(url, token, null, "PUT", data?.toJsonRequestBody()), promise)
    }

    @ReactMethod
    fun patch(url: String, data: ReadableMap?, token: String?, promise: Promise) {
        executeRequest(buildRequest(url, token, null, "PATCH", data?.toJsonRequestBody()), promise)
    }

    @ReactMethod
    fun deleteRequest(url: String, data: ReadableMap?, token: String?, promise: Promise) {
        executeRequest(buildRequest(url, token, null, "DELETE", data?.toJsonRequestBody()), promise)
    }

    private fun buildRequest(url: String, token: String?, params: ReadableMap?, method: String, body: RequestBody?): Request {
        return Request.Builder().url(url).apply {
            token?.let { addHeader("Authorization", "Bearer $it") }
            method(method, body)
        }.build()
    }

    private fun executeRequest(request: Request, promise: Promise) {
        client.newCall(request).enqueue(object : okhttp3.Callback {
            override fun onFailure(call: Call, e: IOException) {
                promise.reject("Network request failed", e)
            }

            override fun onResponse(call: Call, response: Response) {
                if (!response.isSuccessful) {
                    promise.reject("Network request failed", Exception(response.message))
                    return
                }

                val responseBody = response.body?.string() ?: ""
                val responseMap = Arguments.createMap().apply {
                    when {
                        responseBody.startsWith("{") -> putMap("data", JSONObject(responseBody).toWritableMap())
                        responseBody.startsWith("[") -> putArray("data", JSONArray(responseBody).toWritableArray())
                        else -> putString("data", responseBody)
                    }
                    putInt("status", response.code)
                    putMap("headers", response.headers.toWritableMap())
                }

                promise.resolve(responseMap)
            }
        })
    }

    private fun JSONObject.toWritableMap(): WritableMap = Arguments.createMap().apply {
        keys().forEach { key ->
            when (val value = get(key)) {
                is JSONObject -> putMap(key, value.toWritableMap())
                is JSONArray -> putArray(key, value.toWritableArray())
                is Boolean -> putBoolean(key, value)
                is Int -> putInt(key, value)
                is Double -> putDouble(key, value)
                is String -> putString(key, value)
                else -> putString(key, value.toString())
            }
        }
    }

    private fun JSONArray.toWritableArray(): WritableArray = Arguments.createArray().apply {
        for (i in 0 until length()) {
            when (val value = get(i)) {
                is JSONObject -> pushMap(value.toWritableMap())
                is JSONArray -> pushArray(value.toWritableArray())
                is Boolean -> pushBoolean(value)
                is Int -> pushInt(value)
                is Double -> pushDouble(value)
                is String -> pushString(value)
                else -> pushString(value.toString())
            }
        }
    }

    private fun Headers.toWritableMap(): WritableMap = Arguments.createMap().apply {
        for (name in names()) {
            putString(name, get(name))
        }
    }

    private fun ReadableMap.toJsonRequestBody(): RequestBody {
        val jsonString = JSONObject(this.toHashMap()).toString()
        return jsonString.toRequestBody("application/json; charset=utf-8".toMediaTypeOrNull())
    }

    companion object {
        const val NAME = "FastNetwork"
    }
}
