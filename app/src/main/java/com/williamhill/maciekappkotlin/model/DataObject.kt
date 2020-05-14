package com.williamhill.maciekappkotlin.model

import com.squareup.moshi.Json

data class DataObject(
    @Json(name = "data")
    val data: Data?
)

data class Data(
    @Json(name = "count")
    val count: Int?,
    @Json(name = "_embedded")
    val embedded: Embedded?,
    @Json(name = "_links")
    val links: LinksXXX?,
    @Json(name = "total")
    val total: Int?
)

data class Embedded(
    @Json(name = "examples")
    val examples: Examples?
)

data class LinksXXX(
    @Json(name = "self")
    val self: SelfXXX?
)

data class Examples(
    @Json(name = "1")
    val x1: Example?,
    @Json(name = "2")
    val x2: Example?,
    @Json(name = "3")
    val x3: Example?
)

data class Example(
    @Json(name = "avatar")
    val avatar: Avatar?,
    @Json(name = "id")
    val id: Int?,
    @Json(name = "_links")
    val links: Links?,
    @Json(name = "name")
    val name: String?
)

data class Avatar(
    @Json(name = "href")
    val href: String?
)

data class Links(
    @Json(name = "self")
    val self: Self?
)

data class Self(
    @Json(name = "href")
    val href: String?
)

data class AvatarX(
    @Json(name = "href")
    val href: String?
)

data class LinksX(
    @Json(name = "self")
    val self: SelfX?
)

data class SelfX(
    @Json(name = "href")
    val href: String?
)

data class AvatarXX(
    @Json(name = "href")
    val href: String?
)

data class LinksXX(
    @Json(name = "self")
    val self: SelfXX?
)

data class SelfXX(
    @Json(name = "href")
    val href: String?
)

data class SelfXXX(
    @Json(name = "href")
    val href: String?
)