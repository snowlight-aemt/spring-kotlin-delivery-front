package com.snowlightpay.springkotlindeliveryfront.external.order

import java.math.BigDecimal

data class OrderHistoryDTO(
    val orderId: Long,
    val orderStatus: OrderStatus,
    val storeId: Long,
    val storeName: String,
    val menuCount: Int,
    val menuNames: List<String> = emptyList(),
    val menuRepresentativeImageUrl: String,
    val totalOrderAmount: BigDecimal,
)