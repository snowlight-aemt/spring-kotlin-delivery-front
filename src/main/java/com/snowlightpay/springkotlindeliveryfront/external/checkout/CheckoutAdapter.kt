package com.snowlightpay.springkotlindeliveryfront.external.checkout

import com.snowlightpay.springkotlindeliveryfront.exception.NotFoundCheckoutException
import com.snowlightpay.springkotlindeliveryfront.service.checkout.CheckoutRequest
import com.snowlightpay.springkotlindeliveryfront.service.checkout.CheckoutResponse
import com.snowlightpay.springkotlindeliveryfront.service.checkout.CheckoutService
import com.snowlightpay.springkotlindeliveryfront.util.ExternalHttpUtil
import org.springframework.http.HttpEntity
import org.springframework.http.HttpMethod
import org.springframework.stereotype.Component
import org.springframework.util.LinkedMultiValueMap
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.exchange

@Component
class CheckoutAdapter(
    private val restTemplate: RestTemplate,
): CheckoutService {
    override fun getByCheckoutId(checkoutRequest: CheckoutRequest): CheckoutResponse {
        val url = "http://localhost:8081/apis/checkout?customerId=${checkoutRequest.customerId}"
        val httpHeaders = ExternalHttpUtil.getApiHeader(checkoutRequest.accessToken)
        val httpEntity = HttpEntity(LinkedMultiValueMap<String, String>(), httpHeaders)

        val response = restTemplate.exchange<CheckoutResponse>(url, HttpMethod.GET, httpEntity)
        return response.body ?: throw NotFoundCheckoutException()
    }
}
