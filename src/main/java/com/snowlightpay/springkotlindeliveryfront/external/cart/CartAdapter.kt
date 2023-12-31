package com.snowlightpay.springkotlindeliveryfront.external.cart

import com.snowlightpay.springkotlindeliveryfront.controller.cart.CartItemAddRequest
import com.snowlightpay.springkotlindeliveryfront.controller.cart.CartItemAddResponse
import com.snowlightpay.springkotlindeliveryfront.exception.NotFoundCartException
import com.snowlightpay.springkotlindeliveryfront.service.cart.CartResponse
import com.snowlightpay.springkotlindeliveryfront.service.cart.CartRequest
import com.snowlightpay.springkotlindeliveryfront.service.cart.CartService
import com.snowlightpay.springkotlindeliveryfront.util.ExternalHttpUtil
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.util.LinkedMultiValueMap
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.exchange

@Component
class CartAdapter(
    private val restTemplate: RestTemplate,
): CartService {
    override fun getCart(cartRequest: CartRequest): CartResponse {
        val httpHeaders = ExternalHttpUtil.getApiHeader(cartRequest.accessToken)
        val httpEntity = HttpEntity(LinkedMultiValueMap<String, String>(), httpHeaders)
        val response = restTemplate.exchange<CartResponse>(
            "http://localhost:8081/apis/carts/items?customerId=${cartRequest.customerId}",
            HttpMethod.GET,
            httpEntity,
        )
1
        return response.body?: throw NotFoundCartException()
    }

    override fun addCartItem(customerId: Long, accessToken: String, request: CartItemAddRequest): CartItemAddResponse {
        val httpHeaders = ExternalHttpUtil.getApiHeader(accessToken)
        val httpBody = linkedMapOf(
            "storeId" to request.storeId.toString(),
            "menuId" to request.menuId,
            "quantity" to request.quantity,
            "customerId" to customerId.toString(),
        )
        val httpEntity = HttpEntity(httpBody, httpHeaders)
        val response = restTemplate.exchange<CartItemAddResponse>(
            "http://localhost:8081/apis/carts/items",
            HttpMethod.POST,
            httpEntity,
        )

        return response.body?: throw NotFoundCartException()
    }
}