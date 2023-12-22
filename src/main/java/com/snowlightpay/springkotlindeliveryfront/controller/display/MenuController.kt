package com.snowlightpay.springkotlindeliveryfront.controller.display

import com.snowlightpay.springkotlindeliveryfront.service.menu.MenuService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam

@Controller
class MenuController(
    private val menuService: MenuService,
) {
    @GetMapping("/display/menu/{menuId}")
    fun detail(
        @PathVariable menuId: Long,
        @RequestParam storeId: Long,
        model: Model
    ): String {
        val menu = menuService.detail(menuId = menuId, storeId = storeId)

        model.addAttribute("menuDetail", menu)
        model.addAttribute("storeId", storeId)
        model.addAttribute("menuId", menuId)
        model.addAttribute("customerId", 0L)
        return "/display/menu/menu-detail"
    }
}