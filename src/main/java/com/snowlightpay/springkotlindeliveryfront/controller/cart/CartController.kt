package com.snowlightpay.springkotlindeliveryfront.controller.cart

import com.snowlightpay.springkotlindeliveryfront.service.cart.CartRequest
import com.snowlightpay.springkotlindeliveryfront.service.cart.CartService
import com.snowlightpay.springkotlindeliveryfront.service.customer.CustomerRequest
import com.snowlightpay.springkotlindeliveryfront.service.customer.CustomerService
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.CookieValue
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class CartController(
    private val cartService: CartService,
    private val customerService: CustomerService,
) {
    @GetMapping("/cart")
    fun list(
        @CookieValue("customerId") customerId: Long,
        @CookieValue("access-token") accessToken: String,
        model: Model,
    ): String {
        val customer = customerService.getByCustomerId(CustomerRequest(customerId, accessToken))
        val cart = cartService.getCart(CartRequest(customerId, accessToken))

        model.addAttribute("cartItems", cart.cartItems)
        model.addAttribute("canOrder", true)
        model.addAttribute("customer", customer)
        return "/cart/cart"
    }

    @ResponseBody
    @PostMapping("/cart")
    fun add(
        @RequestBody request: CartItemAddRequest,
        @CookieValue("customerId") customerId: Long,
        @CookieValue("access-token") accessToken: String,
    ): ResponseEntity<CartItemAddResponse>{
        val result = cartService.addCartItem(customerId, accessToken, request)
        return ResponseEntity.ok(result)
    }

}