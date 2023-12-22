package com.snowlightpay.springkotlindeliveryfront.service.customer

interface CustomerService {
    fun getByCustomerId(customerRequestL: CustomerRequest): CustomerResponse
}
