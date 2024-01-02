package com.snowlightpay.springkotlindeliveryfront.controller.order.dto

import com.snowlightpay.springkotlindeliveryfront.external.order.OrderStatus
import java.math.BigDecimal

data class OrderHistoryDetailResponse (
    val storeName: String,
    val orderStatus: OrderStatus,
    val menuNames: List<String>,
    val totalOrderAmount: BigDecimal,
)
