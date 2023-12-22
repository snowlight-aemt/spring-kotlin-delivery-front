package com.snowlightpay.springkotlindeliveryfront.external.store

import com.snowlightpay.springkotlindeliveryfront.service.store.StoreDetailResponse
import com.snowlightpay.springkotlindeliveryfront.service.store.StoreService
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForObject
import java.net.URI

@Component
class StoreAdapter(
    private val restTemplate: RestTemplate,
): StoreService {
    override fun detail(storeId: Long): StoreDetailResponse? =
        restTemplate.getForObject(
            "http://localhost:8081/apis/display/stores/$storeId",
            StoreDetailResponse::class.java
        )
}