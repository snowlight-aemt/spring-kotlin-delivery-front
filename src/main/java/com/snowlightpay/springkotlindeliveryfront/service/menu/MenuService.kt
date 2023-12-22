package com.snowlightpay.springkotlindeliveryfront.service.menu

import com.snowlightpay.springkotlindeliveryfront.controller.display.MenuDetailDTO

interface MenuService {
    fun detail(menuId: Long, storeId: Long): MenuDetailDTO
}
