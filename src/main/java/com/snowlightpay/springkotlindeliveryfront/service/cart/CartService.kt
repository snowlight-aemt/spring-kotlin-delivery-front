package com.snowlightpay.springkotlindeliveryfront.service.cart

import com.snowlightpay.springkotlindeliveryfront.controller.cart.CartItemAddRequest
import com.snowlightpay.springkotlindeliveryfront.controller.cart.CartItemAddResponse

interface CartService {
    fun getCart(cartRequest: CartRequest): CartResponse
    fun addCartItem(customerId: Long, accessToken: String, request: CartItemAddRequest): CartItemAddResponse
}
