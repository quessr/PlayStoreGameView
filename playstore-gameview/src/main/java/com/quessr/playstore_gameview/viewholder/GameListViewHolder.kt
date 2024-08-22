package com.quessr.playstore_gameview.viewholder

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.bumptech.glide.Glide
import com.quessr.playstore_gameview.databinding.LayoutBigImageCardBinding
import com.quessr.playstore_gameview.databinding.LayoutListCardBinding
import com.quessr.playstore_gameview.databinding.LayoutSmallImageCardBinding
import com.quessr.playstore_gameview.model.GameListModel

sealed class GameListViewHolder(binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {
    class BigImageCardViewHolder(private val binding: LayoutBigImageCardBinding) :
        GameListViewHolder(binding) {
        fun bind(game: GameListModel.BigImageCard) {
            binding.title.text = game.title
            binding.developer.text = game.developer

            Glide.with(binding.imageView.context)
                .load(game.url)
                .into(binding.imageView)

            Glide.with(binding.ivBanner.context)
                .load(game.bannerUrl)
                .into(binding.ivBanner)
        }
    }

    class ListCardViewHolder(private val binding: LayoutListCardBinding) :
        GameListViewHolder(binding) {
        fun bind(game: GameListModel.ListCard) {
            binding.title.text = game.title
            binding.category.text = game.category
            binding.score.text = game.score

            Glide.with(binding.imageView.context)
                .load(game.url)
                .into(binding.imageView)
        }
    }

    class SmallImageCardViewHolder(private val binding: LayoutSmallImageCardBinding) :
        GameListViewHolder(binding) {
        fun bind(game: GameListModel.SmallImageCard) {
            binding.title.text = game.title
            binding.score.text = game.score

            Glide.with(binding.imageView.context)
                .load(game.url)
                .into(binding.imageView)
        }
    }
}