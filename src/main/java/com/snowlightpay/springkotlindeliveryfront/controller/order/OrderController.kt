package com.snowlightpay.springkotlindeliveryfront.controller.order

import com.snowlightpay.springkotlindeliveryfront.controller.order.dto.OrderHistoryDetailResponse
import com.snowlightpay.springkotlindeliveryfront.controller.order.dto.OrderHistoryRequest
import com.snowlightpay.springkotlindeliveryfront.external.order.OrderStatus
import com.snowlightpay.springkotlindeliveryfront.service.order.OrderHistoryService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.CookieValue
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.ResponseBody
import java.math.BigDecimal

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

    @GetMapping("/order-histories/{orderId}")
    @ResponseBody
    fun orderHistoryDetail(
        @CookieValue("customerId") customerId: String,
        @CookieValue("access-token") accessToken: String,
        @PathVariable orderId: Long
    ) : OrderHistoryDetailResponse {
        val detail = orderHistoryService.detail(orderId, customerId, accessToken)
        return OrderHistoryDetailResponse(
            storeName = detail.storeName,
            orderStatus = detail.orderStatus,
            menuNames = detail.menuNames,
            totalOrderAmount = detail.totalOrderAmount,
        )
    }
}