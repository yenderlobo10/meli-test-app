package com.test.meli.core.data.api.meli.models

import com.squareup.moshi.Json

data class MeliCatalogResult(
    override val keywords: String,
    override val paging: MeliPaging,
    override val results: List<MeliProductItem>
) : MeliSearchResult<MeliProductItem>

data class MeliProductItem(
    val id: String,
    @Json(name = "domain_id") val domainId: String,
    val name: String,
    val attributes: List<MeliAttribute>,
    val pictures: List<MeliPicture>,
    @Json(name = "parent_id") val parentId: String?
)

data class MeliAttribute(
    val id: String,
    val name: String,
    @Json(name = "value_id") val valueId: String?,
    @Json(name = "value_name") val valueName: String?
)

data class MeliPicture(
    val id: String,
    val url: String
)