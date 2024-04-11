package com.test.meli.core.data.api.meli.models

interface MeliSearchResult<T> {

    val keywords: String
    val paging: MeliPaging
    val results: List<T>
}

data class MeliPaging(
    val total: Long,
    val limit: Int,
    val offset: Int
)