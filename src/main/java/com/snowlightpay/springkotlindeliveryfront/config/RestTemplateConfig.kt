package com.snowlightpay.springkotlindeliveryfront.config

import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.http.client.BufferingClientHttpRequestFactory
import org.springframework.http.client.SimpleClientHttpRequestFactory
import org.springframework.web.client.RestTemplate
import java.time.Duration
import java.util.function.Supplier

@Configuration
open class RestTemplateConfig {
    companion object {
        private const val CONNECTION_TIMEOUT = 6000L
        private const val READ_TIMEOUT = 6000L
    }

    @Bean
    open fun restTemplate(restTemplateBuilder: RestTemplateBuilder): RestTemplate =
        restTemplateBuilder
            .requestFactory(
                Supplier { BufferingClientHttpRequestFactory(SimpleClientHttpRequestFactory()) }
            )
            .setConnectTimeout(Duration.ofMillis(CONNECTION_TIMEOUT))
            .setReadTimeout(Duration.ofMinutes(READ_TIMEOUT))
            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .build()
}