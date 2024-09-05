package com.quessr.playstoregameview.data.mapper

import com.quessr.playstore_gameview.model.GameItem
import com.quessr.playstoregameview.data.model.GameListItem

fun gameItemMapper(gameListItem: GameListItem): List<GameItem> {
    return when (gameListItem) {
        is GameListItem.Promo -> gameListItem.items
        is GameListItem.Featured -> gameListItem.items
        is GameListItem.ListChart -> gameListItem.items
    }
}