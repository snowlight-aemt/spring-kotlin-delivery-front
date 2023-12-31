package com.snowlightpay.springkotlindeliveryfront.service.checkout

interface CheckoutService {
    fun getByCheckoutId(checkoutRequest: CheckoutRequest): CheckoutResponse
}