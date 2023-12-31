package com.snowlightpay.springkotlindeliveryfront.controller.order

import com.snowlightpay.springkotlindeliveryfront.controller.order.dto.OrderHistoryRequest
import com.snowlightpay.springkotlindeliveryfront.service.order.OrderHistoryService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.CookieValue
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute

@Controller
class OrderController(
    private val orderHistoryService: OrderHistoryService,
) {
    @GetMapping("/order-histories")
    fun orderHistories(
        @CookieValue("customerId") customerId: String,
        @CookieValue("access-token") accessToken: String,
        @ModelAttribute orderHistoryRequest: OrderHistoryRequest,
        model: Model,
    ): String {
        val list = orderHistoryService.list(orderHistoryRequest, customerId, accessToken)

        model.addAttribute("orderHistories", list.orderHistories)
        model.addAttribute("orderStatus", orderHistoryRequest.orderStatus)

        return "order-history/order-history"
    }
}

// orderHistories
//      storeName
//      enum orderStatus
//      totalOrderAmount
// enum  orderStatus