package com.snowlightpay.springkotlindeliveryfront.service.cart

data class CartRequest(
    val customerId: Long,
    val accessToken: String,
)
