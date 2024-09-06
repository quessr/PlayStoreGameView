package com.quessr.playstoregameview.data.model

import com.quessr.playstore_gameview.model.GameItem

sealed class GameListItem {
    abstract val id: String

    data class Promo(
        override val id: String,
        val items: List<GameItem.BigImagePromoItem>
    ) : GameListItem()

    data class ListChart(
        override val id: String,
        val title: String? = null,
        val items: List<GameItem.ListItem>
    ) : GameListItem()

    data class Featured(
        override val id: String,
        val title: String? = null,
        val items: List<GameItem.BigImageFeaturedItem>
    ) : GameListItem()
}