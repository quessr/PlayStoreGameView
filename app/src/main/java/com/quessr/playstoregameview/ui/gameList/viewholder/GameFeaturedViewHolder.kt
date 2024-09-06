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
    override fun onBind(model: GameListItem, position: Int) {

       val featured = model as? GameListItem.Featured



//        val bigImageFeaturedGameList: List<GameItem> = viewModel.gameListItem.value
//            ?.filterIsInstance<GameListItem.Featured>()
//            ?.flatMap { gameItemMapper(it) }
//            ?: featured?.items.orEmpty()

        val bigImageFeaturedGameList = viewModel.gameListItem.value?.get(position).let { item ->
            item as? GameListItem.Featured
        }

        // bigImageFeaturedGameListView에 데이터를 설정
        bigImageFeaturedGameList?.items?.let { binding.bigImageFeaturedGameListView.submitList(it) }

    }
}