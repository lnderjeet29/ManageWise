package com.inderjeet.ManageWise.business.util

import com.inderjeet.ManageWise.business.dto.PaginatedResponse
import org.modelmapper.ModelMapper
import org.springframework.data.domain.Page

class PaginationHelper {

    fun <U, V> getPageResponse(page: Page<U>, type: Class<V>): PaginatedResponse<V> {
        val list1 = page.content
        val list = list1.map { obj -> ModelMapper().map(obj, type) }
        val skip:Long = page.number.toLong() * page.size.toLong()
        return PaginatedResponse<V>(
            data = list,
            page = page.number,
            total = page.totalElements,
            pageSize = page.size,
            isLastPage = page.isLast,
            totalPages = page.totalPages,
            skip = skip
        )
    }
}