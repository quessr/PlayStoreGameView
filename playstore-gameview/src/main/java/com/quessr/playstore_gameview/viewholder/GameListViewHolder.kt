package com.quessr.playstore_gameview.viewholder

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.quessr.playstore_gameview.databinding.LayoutBigImageCardBinding
import com.quessr.playstore_gameview.databinding.LayoutListCardBinding
import com.quessr.playstore_gameview.databinding.LayoutSmallImageCardBinding
import com.quessr.playstore_gameview.model.GameListModel

sealed class GameListViewHolder(binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {
    class BigImageCardViewHolder(private val binding: LayoutBigImageCardBinding) :
        GameListViewHolder(binding) {
        fun bind(game: GameListModel.BigImageCard) {
            binding.title.text = game.title
        }
    }

    class ListCardViewHolder(private val binding: LayoutListCardBinding) :
        GameListViewHolder(binding) {
        fun bind(game: GameListModel.ListCard) {
            binding.title.text = game.title
        }
    }

    class SmallImageCardViewHolder(private val binding: LayoutSmallImageCardBinding) :
        GameListViewHolder(binding) {
        fun bind(game: GameListModel.SmallImageCard) {
            binding.title.text = game.title
        }
    }
}