package com.snowlightpay.springkotlindeliveryfront.service.customer

data class CustomerRequest(
    val customerId: Long,
    val accessToken: String,
)
