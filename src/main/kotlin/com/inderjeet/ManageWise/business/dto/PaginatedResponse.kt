package com.inderjeet.ManageWise.business.dto

data class PaginatedResponse<T>(
    val data: List<T>,
    val page: Int,
    val pageSize: Int,
    val total: Long,
    val totalPages: Int,
    val isLastPage: Boolean,
    val skip: Long
)