package com.snowlightpay.springkotlindeliveryfront.service.cart

data class CartItemsDto (
    val cartItemId: Long,
    val cartId: Long,
    val storeId: Long,
    val menuId: Long,
    var quantity: Int,
)
