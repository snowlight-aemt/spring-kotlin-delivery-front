package com.snowlightpay.springkotlindeliveryfront.controller.cart

data class CartItemAddRequest (
    val storeId: Long,
    val menuId: Long,
    val quantity: Int
)
