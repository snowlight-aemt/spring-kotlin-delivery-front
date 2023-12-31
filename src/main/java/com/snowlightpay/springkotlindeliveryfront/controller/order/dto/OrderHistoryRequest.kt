package com.snowlightpay.springkotlindeliveryfront.controller.order.dto

import com.snowlightpay.springkotlindeliveryfront.external.order.OrderStatus

data class OrderHistoryRequest (
    var orderStatus: OrderStatus = OrderStatus.READY,
)
