package com.snowlightpay.springkotlindeliveryfront.service.store

import org.springframework.stereotype.Service

@Service
interface StoreService {
    fun detail(storeId: Long): StoreDetailResponse?
}
