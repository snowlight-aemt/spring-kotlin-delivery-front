package com.snowlightpay.springkotlindeliveryfront.service.checkout

data class CheckoutDto (
    val checkoutItemId: Long,
    val menuId: Long,
    val menuPrice: Long,
    val menuQuantity: Long,
)