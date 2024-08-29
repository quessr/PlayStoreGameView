package com.quessr.playstoregameview.data.datasource.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GameResponse(val content: List<GameItem>) : Parcelable {

    @Parcelize
    data class GameItem(
        val id: Int,
        val title: String,
        val developer: String,
        val score: String?,
        val url: String,
        val category: Int,
        val pkg: String
    ) : Parcelable

}

