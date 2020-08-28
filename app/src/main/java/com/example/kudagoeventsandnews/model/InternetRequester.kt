package com.example.kudagoeventsandnews.model

import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.net.URL

class InternetRequester {
    suspend fun requestDataList(urlString:String): String {
        var jsonString = ""
        val client = OkHttpClient()

        val url =
            URL( urlString )
        val request: Request = Request.Builder()
            .url(url)
            .build()

        val response: Response = client.newCall(request).execute()
        response.body.let { jsonString = it?.string()!! }
        return jsonString
    }

    fun requestDataListWithoutCorutine(urlString:String): String {
        var jsonString = ""
        val client = OkHttpClient()

        val url =
            URL( urlString )
        val request: Request = Request.Builder()
            .url(url)
            .build()

        val response: Response = client.newCall(request).execute()
        response.body.let { jsonString = it?.string()!! }
        return jsonString
    }
}