package com.quessr.playstoregameview.ui.gameList.viewholder

import com.quessr.playstore_gameview.model.GameItem
import com.quessr.playstoregameview.data.mapper.gameItemMapper
import com.quessr.playstoregameview.data.model.GameListItem
import com.quessr.playstoregameview.databinding.ItemGameListSmallBinding
import com.quessr.playstoregameview.ui.gameList.GameListViewModel

class GameSmallViewHolder(
    private val binding: ItemGameListSmallBinding,
    private val viewModel: GameListViewModel
) : BaseGameListViewHolder<GameListItem, ItemGameListSmallBinding>(binding) {
    override fun onBind(model: GameListItem, position: Int) {
        val small = model as? GameListItem.Small

        binding.title.text = small?.title

        val smallGameList: List<GameItem> = viewModel.gameListItem.value
            ?.filterIsInstance<GameListItem.Small>()
            ?.flatMap { gameItemMapper(it) }
            ?: small?.items.orEmpty()

        // bigImageGameListView에 데이터를 설정
        binding.smallImageGameListView.submitList(smallGameList)
    }
}