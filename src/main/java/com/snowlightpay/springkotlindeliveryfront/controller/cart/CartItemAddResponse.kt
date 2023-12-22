package com.snowlightpay.springkotlindeliveryfront.controller.cart

data class CartItemAddResponse (
    val storeId: Long,
    val menuId: Long,
    val quantity: Int,
)
