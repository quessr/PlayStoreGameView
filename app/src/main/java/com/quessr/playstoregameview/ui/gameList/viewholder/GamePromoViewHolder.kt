package com.quessr.playstoregameview.ui.gameList.viewholder

import android.util.Log
import com.quessr.playstore_gameview.model.GameItem
import com.quessr.playstoregameview.data.mapper.gameItemMapper
import com.quessr.playstoregameview.data.model.GameListItem
import com.quessr.playstoregameview.databinding.ItemGameListPromoBinding

class GamePromoViewHolder(
    private val binding: ItemGameListPromoBinding,
    private val getGameList: () -> List<GameListItem>?
) :
    BaseGameListViewHolder<GameListItem, ItemGameListPromoBinding>(binding) {
    override fun onBind(model: GameListItem, position: Int) {
        val promo = model as? GameListItem.Promo

        Log.d("GamePromoViewHolder", "GamePromoViewHolder")

        val bigImagePromoGameList: List<GameItem> = getGameList()
            ?.filterIsInstance<GameListItem.Promo>()
            ?.flatMap { gameItemMapper(it) }
            ?: promo?.items.orEmpty()

        // bigImageGameListView에 데이터를 설정
        binding.bigImagePromoGameListView.submitList(bigImagePromoGameList)

        Log.d("GamePromoViewHolder", "bigImageGameList: $bigImagePromoGameList")
    }
}