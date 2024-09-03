package com.quessr.playstore_gameview.model

sealed class GameItem() {
    abstract val id: String

    data class BigImageItem(
        override val id: String,
        val title: String,
        val developer: String? = null,
        val category: String? = null,
        val score: String? = null,
        val url: String,
        val bannerUrl: String?
    ) : GameItem()

    data class SmallImageItem(
        override val id: String,
        val title: String,
        val score: String,
        val url: String,
    ) : GameItem()

    data class ListItem(
        override val id: String,
        val title: String,
        val category: String,
        val score: String,
        val url: String,
    ) : GameItem()
}