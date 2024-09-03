package com.quessr.playstoregameview.ui.gameList

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.viewbinding.ViewBinding
import com.quessr.playstore_gameview.model.GameItem
import com.quessr.playstoregameview.databinding.ItemGameListPromoBinding
import com.quessr.playstoregameview.ui.gameList.viewholder.BaseGameListViewHolder
import com.quessr.playstoregameview.ui.gameList.viewholder.GamePromoViewHolder

class GameListAdapter(private val viewModel: GameListViewModel) :
    ListAdapter<GameItem, BaseGameListViewHolder<out GameItem, out ViewBinding>>(
        diffUtil
    ) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): BaseGameListViewHolder<out GameItem, out ViewBinding> {
        Log.d("GameListAdapter", "GameListAdapter")
        fun <VB : ViewBinding> inflateBinding(bindingInflate: (LayoutInflater, ViewGroup, Boolean) -> VB) =
            bindingInflate.invoke(LayoutInflater.from(parent.context), parent, false)
        return when (viewType) {
            ITEM_TYPE_PROMO -> GamePromoViewHolder(inflateBinding(ItemGameListPromoBinding::inflate), viewModel)
            else -> {
                GamePromoViewHolder(inflateBinding(ItemGameListPromoBinding::inflate), viewModel)
            }
        }
    }

    override fun onBindViewHolder(
        holder: BaseGameListViewHolder<out GameItem, out ViewBinding>,
        position: Int
    ) {
        when (val item = getItem(position)) {
            is GameItem.BigImageItem -> (holder as? GamePromoViewHolder)?.onBind(model = item)
            is GameItem.ListItem -> TODO()
            is GameItem.SmallImageItem -> TODO()
        }
    }

    override fun getItemViewType(position: Int): Int =
        when (getItem(position)) {
            is GameItem.BigImageItem -> ITEM_TYPE_PROMO
            is GameItem.ListItem -> TODO()
            is GameItem.SmallImageItem -> TODO()
        }

    companion object {
        private const val ITEM_TYPE_PROMO = 1
        private val diffUtil = object : DiffUtil.ItemCallback<GameItem>() {
            override fun areItemsTheSame(oldItem: GameItem, newItem: GameItem): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: GameItem, newItem: GameItem): Boolean {
                return oldItem == newItem
            }
        }
    }
}