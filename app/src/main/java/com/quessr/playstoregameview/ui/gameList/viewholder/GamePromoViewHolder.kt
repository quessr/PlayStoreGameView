package com.quessr.playstoregameview.ui.gameList.viewholder

import android.util.Log
import com.quessr.playstore_gameview.model.GameItem
import com.quessr.playstoregameview.databinding.ItemGameListPromoBinding
import com.quessr.playstoregameview.ui.gameList.GameListViewModel

class GamePromoViewHolder(
    private val binding: ItemGameListPromoBinding,
    private val viewModel: GameListViewModel
) :
    BaseGameListViewHolder<GameItem.BigImageItem, ItemGameListPromoBinding>(binding) {
    override fun onBind(model: GameItem.BigImageItem) {
        super.onBind(model)

        Log.d("GamePromoViewHolder", "GamePromoViewHolder")


        // GameItem.BigImageItem을 리스트로 변환
        val bigImageGameList = viewModel.bigImageGameList.value ?: listOf(model)
        // bigImageGameListView에 데이터를 설정
        binding.bigImageGameListView.submitList(bigImageGameList)

        Log.d("GamePromoViewHolder", "bigImageGameList: $bigImageGameList")
    }
}