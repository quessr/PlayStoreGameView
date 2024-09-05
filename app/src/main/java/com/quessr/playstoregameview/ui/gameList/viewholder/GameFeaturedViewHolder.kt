package com.quessr.playstoregameview.ui.gameList.viewholder

import android.util.Log
import com.quessr.playstore_gameview.model.GameItem
import com.quessr.playstoregameview.data.mapper.gameItemMapper
import com.quessr.playstoregameview.data.model.GameListItem
import com.quessr.playstoregameview.databinding.ItemGameListFeaturedBinding
import com.quessr.playstoregameview.ui.gameList.GameListViewModel

class GameFeaturedViewHolder(
    private val binding: ItemGameListFeaturedBinding,
    private val viewModel: GameListViewModel
) :
    BaseGameListViewHolder<GameListItem, ItemGameListFeaturedBinding>(binding) {
    override fun onBind(model: GameListItem) {
       val featured = model as? GameListItem.Featured

//        val bigImageFeaturedGameList = viewModel.combinedGameList.value ?: featured?.items
//        if (bigImageFeaturedGameList != null) {
//            binding.bigImageFeaturedGameListView.submitList(bigImageFeaturedGameList)
//        }

        val bigImageFeaturedGameList: List<GameItem> = viewModel.gameListItem.value
            ?.filterIsInstance<GameListItem.Featured>()
            ?.flatMap { gameItemMapper(it) }
            ?: featured?.items.orEmpty()

        // bigImageFeaturedGameListView에 데이터를 설정
        binding.bigImageFeaturedGameListView.submitList(bigImageFeaturedGameList)

        Log.d("bigImageFeaturedGameList", "bigImageFeaturedGameList : $bigImageFeaturedGameList")
    }
}