package com.snowlightpay.springkotlindeliveryfront.external.customer

import com.snowlightpay.springkotlindeliveryfront.exception.NotFoundCustomerException
import com.snowlightpay.springkotlindeliveryfront.service.customer.CustomerRequest
import com.snowlightpay.springkotlindeliveryfront.service.customer.CustomerResponse
import com.snowlightpay.springkotlindeliveryfront.service.customer.CustomerService
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
class CustomerAdapter(
    private val restTemplate: RestTemplate,
): CustomerService {
    override fun getByCustomerId(customerRequest: CustomerRequest): CustomerResponse {
        val httpHeaders = ExternalHttpUtil.getApiHeader(customerRequest.accessToken)
        val httpEntity = HttpEntity(LinkedMultiValueMap<String, String>(), httpHeaders)
        val exchange = restTemplate.exchange<CustomerResponse>(
            "http://localhost:8081/apis/customer/${customerRequest.customerId}",
            HttpMethod.GET,
            httpEntity,
        )

        return exchange.body?: throw NotFoundCustomerException()
    }
}