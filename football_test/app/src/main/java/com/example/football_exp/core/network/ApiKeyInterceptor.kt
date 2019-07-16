package com.example.football_exp.core.network

import com.example.football_exp.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class ApiKeyInterceptor: Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response = chain.run{
        val newUrl = chain.request()
            .url().
                newBuilder()
            .build()

        val newRequest = chain.request()
            .newBuilder()
            .url(newUrl)
            .addHeader("X-Auth-Token", BuildConfig.FOOTBALL_DATA_ORG_API_KEY)
            .build()

        chain.proceed(newRequest)
    }
}