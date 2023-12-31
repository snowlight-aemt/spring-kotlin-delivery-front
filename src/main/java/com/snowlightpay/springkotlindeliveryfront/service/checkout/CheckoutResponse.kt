package com.snowlightpay.springkotlindeliveryfront.service.checkout

data class CheckoutResponse (
    val customerId: Long,
    val storeId: Long,
    val totalAmountForPayment: Long,
    val checkoutItems: List<CheckoutDto>
)