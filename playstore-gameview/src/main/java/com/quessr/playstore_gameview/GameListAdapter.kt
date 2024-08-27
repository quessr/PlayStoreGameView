package com.quessr.playstore_gameview

import android.content.Context
import android.provider.SyncStateContract.Constants
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.quessr.playstore_gameview.model.GameItem
import com.quessr.playstore_gameview.viewholder.GameListViewHolder
import androidx.recyclerview.widget.ListAdapter
import androidx.viewbinding.ViewBinding
import com.quessr.playstore_gameview.common.constants.GameItemConstants
import com.quessr.playstore_gameview.common.constants.ImageSizeConstants
import com.quessr.playstore_gameview.databinding.LayoutBigImageCardBinding
import com.quessr.playstore_gameview.databinding.LayoutListCardBinding
import com.quessr.playstore_gameview.databinding.LayoutSmallImageCardBinding

class GameListAdapter(private val context: Context, private val cardType: Int) :
    ListAdapter<GameItem, GameListViewHolder>(diffUtil) {
    private var sizeType: Int = 0

    fun setSizeType(size: Int) {
        sizeType = size
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameListViewHolder {
        Log.d("GameListAdapter", "GameListAdapter")
        val context = parent.context

        fun <VB : ViewBinding> inflateBinding(bindingInflate: (LayoutInflater, ViewGroup, Boolean) -> VB) =
            bindingInflate.invoke(LayoutInflater.from(context), parent, false)

        return when (cardType) {
            GameItemConstants.ITEM_BIG_IMAGE_CARD -> {
                val binding = inflateBinding(LayoutBigImageCardBinding::inflate)
                GameListViewHolder.BigImageCardViewHolder(binding)
            }

            GameItemConstants.ITEM_LIST_CARD -> {
                val binding = inflateBinding(LayoutListCardBinding::inflate)
                GameListViewHolder.ListCardViewHolder(binding)
            }

            GameItemConstants.ITEM_SMALL_IMAGE_CARD -> {
                val binding = inflateBinding(LayoutSmallImageCardBinding::inflate)
                GameListViewHolder.SmallImageCardViewHolder(binding)
            }

            else -> {
                Log.d("GameListAdapter", "onCreateViewHolder else")
                val binding = inflateBinding(LayoutBigImageCardBinding::inflate)
                GameListViewHolder.BigImageCardViewHolder(binding)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is GameItem.BigImageItem -> GameItemConstants.ITEM_BIG_IMAGE_CARD
            is GameItem.ListItem -> GameItemConstants.ITEM_LIST_CARD
            is GameItem.SmallImageItem -> GameItemConstants.ITEM_SMALL_IMAGE_CARD
            else -> throw IllegalArgumentException("Unknown view type")
        }
    }

    override fun onBindViewHolder(holder: GameListViewHolder, position: Int) {
        val item = getItem(position)
        holder.onBind(item)

        if (holder is GameListViewHolder.BigImageCardViewHolder) {
            holder.setImageViewSize(
                if (sizeType == ImageSizeConstants.SIZE_SMALL) context.resources.getDimensionPixelSize(
                    R.dimen.small_image_size
                ) else context.resources.getDimensionPixelSize(R.dimen.big_image_size)
            )
            holder.setButtonVisibility(sizeType)
        }
    }

    companion object {
        private val diffUtil = object : DiffUtil.ItemCallback<GameItem>() {
            override fun areContentsTheSame(
                oldItem: GameItem,
                newItem: GameItem
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areItemsTheSame(oldItem: GameItem, newItem: GameItem): Boolean {
                return oldItem == newItem
            }
        }
    }

}