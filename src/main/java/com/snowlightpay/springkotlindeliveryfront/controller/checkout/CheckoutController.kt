package com.snowlightpay.springkotlindeliveryfront.controller.checkout

import com.snowlightpay.springkotlindeliveryfront.service.checkout.CheckoutRequest
import com.snowlightpay.springkotlindeliveryfront.service.checkout.CheckoutService
import com.snowlightpay.springkotlindeliveryfront.service.customer.CustomerRequest
import com.snowlightpay.springkotlindeliveryfront.service.customer.CustomerService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.CookieValue
import org.springframework.web.bind.annotation.GetMapping

@Controller
class CheckoutController(
    private val checkoutService: CheckoutService,
    private val customerService: CustomerService,
) {
    @GetMapping("/checkout")
    fun list(
        @CookieValue("customerId") customerId: Long,
        @CookieValue("access-token") accessToken: String,
        model: Model,
    ): String {
        val customerResponse = customerService.getByCustomerId(CustomerRequest(customerId, accessToken))
        val checkoutResponse = checkoutService.getByCheckoutId(CheckoutRequest(customerId, accessToken))

        model.addAttribute("checkoutId", customerId)
        model.addAttribute("customer",customerResponse)
        model.addAttribute("totalAmountForPayment", checkoutResponse.totalAmountForPayment)

        return "checkout/checkout"
    }
}