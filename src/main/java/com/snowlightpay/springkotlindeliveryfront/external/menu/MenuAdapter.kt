package com.snowlightpay.springkotlindeliveryfront.external.menu

import com.snowlightpay.springkotlindeliveryfront.controller.display.MenuDetailDTO
import com.snowlightpay.springkotlindeliveryfront.service.menu.MenuService
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForObject

@Component
open class MenuAdapter(
    private val restTemplate: RestTemplate,
): MenuService {
    override fun detail(menuId: Long, storeId: Long): MenuDetailDTO {
        // TODO 응답에 값이 없는 경우 - 에러 발생 예외 처리
        val menuUrl = "http://localhost:8081/apis/display/menu/$menuId?storeId=$storeId"
        val response = restTemplate.getForObject<MenuDetailResponse>(menuUrl)

        return MenuDetailDTO(
            menuId = response.menuId,
            menuName = response.menuName,
            storeId = response.storeId,
            menuPrice = response.price,
            description = response.description,
            menuMainImageUrl = response.menuMainImageUrl,
        )
    }
}
