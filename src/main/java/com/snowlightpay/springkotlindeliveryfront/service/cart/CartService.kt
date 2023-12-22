package com.snowlightpay.springkotlindeliveryfront.service.cart

interface CartService {
    fun getCart(cartRequest: CartRequest): CartResponse
}
