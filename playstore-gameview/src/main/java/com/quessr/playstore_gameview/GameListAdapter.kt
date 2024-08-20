package com.quessr.playstore_gameview

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.quessr.playstore_gameview.model.GameListModel
import com.quessr.playstore_gameview.viewholder.GameListViewHolder
import androidx.recyclerview.widget.ListAdapter
import com.quessr.playstore_gameview.databinding.LayoutBigImageCardBinding
import com.quessr.playstore_gameview.databinding.LayoutListCardBinding
import com.quessr.playstore_gameview.databinding.LayoutSmallImageCardBinding

class GameListAdapter(private val cardType: Int) :
    ListAdapter<GameListModel, GameListViewHolder>(diffUtil) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameListViewHolder {
        Log.d("GameListAdapter", "GameListAdapter")
        return when (cardType) {
            0 -> GameListViewHolder.BigImageCardViewHolder(
                LayoutBigImageCardBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )

            1 -> GameListViewHolder.ListCardViewHolder(
                LayoutListCardBinding.inflate(
                    LayoutInflater.from(
                        parent.context
                    ), parent, false
                )
            )

            2 -> GameListViewHolder.SmallImageCardViewHolder(
                LayoutSmallImageCardBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )

            else -> GameListViewHolder.BigImageCardViewHolder(
                LayoutBigImageCardBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is GameListModel.BigImageCard -> 0
            is GameListModel.ListCard -> 1
            is GameListModel.SmallImageCard -> 2
            else -> throw IllegalArgumentException("Unknown view type")
        }
    }

    override fun onBindViewHolder(holder: GameListViewHolder, position: Int) {

        Log.d("GameListAdapter", "onBindViewHolder")

        val game = getItem(position)
        when (holder) {
            is GameListViewHolder.BigImageCardViewHolder -> holder.bind(game as GameListModel.BigImageCard)
            is GameListViewHolder.ListCardViewHolder -> holder.bind(game as GameListModel.ListCard)
            is GameListViewHolder.SmallImageCardViewHolder -> holder.bind(game as GameListModel.SmallImageCard)
        }
    }

    companion object {
        private val diffUtil = object : DiffUtil.ItemCallback<GameListModel>() {
            override fun areContentsTheSame(
                oldItem: GameListModel,
                newItem: GameListModel
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areItemsTheSame(oldItem: GameListModel, newItem: GameListModel): Boolean {
                return oldItem == newItem
            }
        }
    }

}