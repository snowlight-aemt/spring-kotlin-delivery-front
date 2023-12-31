package com.snowlightpay.springkotlindeliveryfront.controller.order.dto

import java.math.BigDecimal

data class OrderItem (
    val orderItemId: Long,
    val orderId: Long,
    val menuId: Long,
    val menuPrice: BigDecimal,
    val menuQuantity: Int,
)