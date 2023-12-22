package com.snowlightpay.springkotlindeliveryfront.util

import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType

class ExternalHttpUtil {
    companion object {
        fun getApiHeader(token: String): HttpHeaders {
            val httpHeaders = HttpHeaders()
            httpHeaders.contentType = MediaType.APPLICATION_JSON
            httpHeaders.add(HttpConstants.HEADER_AUTHORIZATION, "Bearer $token")

            return httpHeaders
        }
    }
}