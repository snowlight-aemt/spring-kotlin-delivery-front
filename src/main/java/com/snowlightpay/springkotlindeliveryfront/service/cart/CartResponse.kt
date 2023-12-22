package com.snowlightpay.springkotlindeliveryfront.service.cart

data class CartResponse(
    val customerId: Long,
    val cartItems: List<CartItemResponse>
)
