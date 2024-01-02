package com.snowlightpay.springkotlindeliveryfront.external.order

import com.snowlightpay.springkotlindeliveryfront.controller.order.dto.OrderHistoryDetailResponse
import com.snowlightpay.springkotlindeliveryfront.controller.order.dto.OrderHistoryRequest
import com.snowlightpay.springkotlindeliveryfront.service.order.OrderHistoryService
import com.snowlightpay.springkotlindeliveryfront.util.ExternalHttpUtil
import org.springframework.http.HttpEntity
import org.springframework.http.HttpMethod
import org.springframework.stereotype.Component
import org.springframework.util.LinkedMultiValueMap
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.exchange
import org.springframework.web.client.getForObject

@Component
class OrderHistoryAdapter(
    private val restTemplate: RestTemplate,
): OrderHistoryService {
    override fun list(orderHistoryRequest: OrderHistoryRequest, customerId: String, accessToken: String): OrderHistoryResponse {
        val url = "http://localhost:8081/apis/order-history?customerId=${customerId}&orderStatus=${orderHistoryRequest.orderStatus}"
        val response = restTemplate.getForObject<OrderHistoryResponse>(url)

        return response
    }

    override fun detail(orderId: Long, customerId: String, accessToken: String): OrderHistoryDetailResponse {
        val url = "http://localhost:8081/apis/order-history/$orderId"
        val response = restTemplate.getForObject<OrderHistoryDetailResponse>(url)

        return response
    }
}