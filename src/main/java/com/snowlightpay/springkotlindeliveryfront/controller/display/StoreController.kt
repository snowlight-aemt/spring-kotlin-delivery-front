package com.snowlightpay.springkotlindeliveryfront.controller.display

import com.snowlightpay.springkotlindeliveryfront.service.store.StoreService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@Controller
class StoreController(
    private val storeService: StoreService,
) {
    @GetMapping("/display/store/{storeId}")
    fun detail(@PathVariable storeId: Long, model: Model): String {
        val store = storeService.detail(storeId = storeId)
        model.addAttribute("store", store)
        store?.let { model.addAttribute("menus", it.menus) }
        return "/display/store/store-detail"
    }
}