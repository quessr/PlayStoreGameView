package com.quessr.playstore_gameview.model

sealed class GameListModel() {
    abstract val id: String

    data class BigImageCard(
        override val id: String,
        val title: String,
        val developer: String,
        val url: String,
        val bannerUrl: String
    ) : GameListModel()

    data class SmallImageCard(
        override val id: String,
        val title: String,
        val score: String,
        val url: String,
    ) : GameListModel()

    data class ListCard(
        override val id: String,
        val title: String,
        val category: String,
        val score: String,
        val url: String,
    ) : GameListModel()
}