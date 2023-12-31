package com.snowlightpay.springkotlindeliveryfront.service.checkout

data class CheckoutRequest (
    val customerId: Long,
    val accessToken: String,
)