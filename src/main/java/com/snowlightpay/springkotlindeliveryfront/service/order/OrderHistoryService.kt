package com.snowlightpay.springkotlindeliveryfront.service.order

import com.snowlightpay.springkotlindeliveryfront.controller.order.dto.OrderHistoryDetailResponse
import com.snowlightpay.springkotlindeliveryfront.controller.order.dto.OrderHistoryRequest
import com.snowlightpay.springkotlindeliveryfront.external.order.OrderHistoryResponse

interface OrderHistoryService {
    fun list(orderHistoryRequest: OrderHistoryRequest, customerId: String, accessToken: String): OrderHistoryResponse
    fun detail(orderId: Long, customerId: String, accessToken: String): OrderHistoryDetailResponse
}
