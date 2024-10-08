package com.quessr.playstoregameview.ui.gameList.viewholder

import com.quessr.playstore_gameview.model.GameItem
import com.quessr.playstoregameview.data.mapper.gameItemMapper
import com.quessr.playstoregameview.data.model.GameListItem
import com.quessr.playstoregameview.databinding.ItemGameListChartBinding
import com.quessr.playstoregameview.ui.gameList.GameListViewModel

class GameListChartViewHolder(
    private val binding: ItemGameListChartBinding,
    private val getGameList: () -> List<GameListItem>?
) : BaseGameListViewHolder<GameListItem, ItemGameListChartBinding>(binding) {
    override fun onBind(model: GameListItem, position: Int) {
        val listCart = model as? GameListItem.ListChart

        binding.title.text = listCart?.title

        val listChartGameList: List<GameItem> = getGameList()
            ?.filterIsInstance<GameListItem.ListChart>()
            ?.flatMap { gameItemMapper(it) }
            ?: listCart?.items.orEmpty()

        // bigImageGameListView에 데이터를 설정
        binding.listChartGameListView.submitList(listChartGameList)
    }
}