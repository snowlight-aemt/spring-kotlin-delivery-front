package com.snowlightpay.springkotlindeliveryfront.service.store

import com.snowlightpay.springkotlindeliveryfront.external.menu.MenuDTO
import java.math.BigDecimal

data class StoreDetailResponse (
    val storeId: Long,
    val storeName: String,
    val phone: String,
    val address: String,
    val deliveryFee: BigDecimal,
    val deliveryTime: String,
    val reviewGrade: Int,
    val storeMainImageUrl: String,
    val description: String,
    val minimumOrderPrice: BigDecimal,
    val menus: List<MenuDTO>
)
