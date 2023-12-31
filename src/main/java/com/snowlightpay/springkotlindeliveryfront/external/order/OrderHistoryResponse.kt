package com.snowlightpay.springkotlindeliveryfront.external.order

data class OrderHistoryResponse (
    val orderHistories: List<OrderHistoryDTO> = emptyList()
)