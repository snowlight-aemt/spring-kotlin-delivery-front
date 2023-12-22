package com.snowlightpay.springkotlindeliveryfront.controller.display

import java.math.BigDecimal

data class MenuDetailDTO (
    val menuId: Long,
    val menuName: String,
    val storeId: Long,
    val menuPrice: BigDecimal,
    val description: String,
    val menuMainImageUrl: String,
)