package com.quessr.playstoregameview.ui.gameList

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.viewbinding.ViewBinding
import com.quessr.playstoregameview.data.model.GameListItem
import com.quessr.playstoregameview.databinding.ItemGameListChartBinding
import com.quessr.playstoregameview.databinding.ItemGameListFeaturedBinding
import com.quessr.playstoregameview.databinding.ItemGameListPromoBinding
import com.quessr.playstoregameview.databinding.ItemGameListSmallBinding
import com.quessr.playstoregameview.ui.gameList.viewholder.BaseGameListViewHolder
import com.quessr.playstoregameview.ui.gameList.viewholder.GameFeaturedViewHolder
import com.quessr.playstoregameview.ui.gameList.viewholder.GameListChartViewHolder
import com.quessr.playstoregameview.ui.gameList.viewholder.GamePromoViewHolder
import com.quessr.playstoregameview.ui.gameList.viewholder.GameSmallViewHolder

class GameListAdapter(private val getGameList: LiveData<List<GameListItem>>) :
    ListAdapter<GameListItem, BaseGameListViewHolder<out GameListItem, out ViewBinding>>(
        diffUtil
    ) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): BaseGameListViewHolder<out GameListItem, out ViewBinding> {
        Log.d("GameListAdapter", "GameListAdapter")
        fun <VB : ViewBinding> inflateBinding(bindingInflate: (LayoutInflater, ViewGroup, Boolean) -> VB) =
            bindingInflate.invoke(LayoutInflater.from(parent.context), parent, false)
        return when (viewType) {
            ITEM_TYPE_PROMO -> GamePromoViewHolder(
                inflateBinding(ItemGameListPromoBinding::inflate),
            ) { getGameList.value }

            ITEM_TYPE_FEATURED -> GameFeaturedViewHolder(
                inflateBinding(ItemGameListFeaturedBinding::inflate),
            ) { getGameList.value }

            ITEM_TYPE_LIST_CHART -> GameListChartViewHolder(
                inflateBinding(ItemGameListChartBinding::inflate)
            ) { getGameList.value }

            ITEM_TYPE_SMALL -> GameSmallViewHolder(
                inflateBinding(ItemGameListSmallBinding::inflate)
            ) { getGameList.value }

            else -> {
                GamePromoViewHolder(
                    inflateBinding(ItemGameListPromoBinding::inflate)
                ) { getGameList.value }
            }
        }
    }

    override fun onBindViewHolder(
        holder: BaseGameListViewHolder<out GameListItem, out ViewBinding>,
        position: Int
    ) {
        when (val gameListItem = getItem(position)) {
            is GameListItem.Promo -> (holder as? GamePromoViewHolder)?.onBind(
                model = gameListItem,
                position = position
            )
//            is GameListItem.Featured -> (holder as? GameFeaturedViewHolder)?.onBind(model = gameListItem)
            is GameListItem.Featured -> {

                when (position) {
                    0 -> {
                        (holder as? GameFeaturedViewHolder)?.onBind(
                            model = gameListItem,
                            position = position
                        )
                    }

                    1 -> {
                        (holder as? GameFeaturedViewHolder)?.onBind(
                            model = gameListItem,
                            position = position
                        )
                    }

                    else -> {
                        (holder as? GameFeaturedViewHolder)?.onBind(
                            model = gameListItem,
                            position = position
                        )
                    }
                }
            }

            is GameListItem.ListChart -> (holder as? GameListChartViewHolder)?.onBind(
                model = gameListItem,
                position = position
            )

            is GameListItem.Small -> (holder as? GameSmallViewHolder)?.onBind(
                model = gameListItem,
                position = position
            )
        }
    }

    override fun getItemViewType(position: Int): Int =
        when (getItem(position)) {
            is GameListItem.Promo -> ITEM_TYPE_PROMO
            is GameListItem.Featured -> ITEM_TYPE_FEATURED
            is GameListItem.ListChart -> ITEM_TYPE_LIST_CHART
            is GameListItem.Small -> ITEM_TYPE_SMALL
        }

    companion object {
        private const val ITEM_TYPE_PROMO = 1
        private const val ITEM_TYPE_FEATURED = 2
        private const val ITEM_TYPE_LIST_CHART = 3
        private const val ITEM_TYPE_SMALL = 4

        private val diffUtil = object : DiffUtil.ItemCallback<GameListItem>() {
            override fun areItemsTheSame(oldItem: GameListItem, newItem: GameListItem): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: GameListItem, newItem: GameListItem): Boolean {
                return oldItem == newItem
            }
        }
    }
}