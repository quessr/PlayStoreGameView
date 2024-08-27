package com.quessr.playstore_gameview.viewholder

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.bumptech.glide.Glide
import com.quessr.playstore_gameview.databinding.LayoutBigImageCardBinding
import com.quessr.playstore_gameview.databinding.LayoutListCardBinding
import com.quessr.playstore_gameview.databinding.LayoutSmallImageCardBinding
import com.quessr.playstore_gameview.model.GameItem

sealed class GameListViewHolder(binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {

    open fun onBind(gameItem: GameItem) {}
    class BigImageCardViewHolder(private val binding: LayoutBigImageCardBinding) :
        GameListViewHolder(binding) {
        private var gameModel: GameItem.BigImageItem? = null
        override fun onBind(gameItem: GameItem) {
            gameModel = gameItem as? GameItem.BigImageItem
            with(binding) {
                title.text = gameModel?.title
                developer.text = gameModel?.developer
            }

            Glide.with(binding.imageView.context)
                .load(gameModel?.url)
                .into(binding.imageView)

            Glide.with(binding.ivBanner.context)
                .load(gameModel?.bannerUrl)
                .into(binding.ivBanner)
        }

        fun setImageViewSize(size: Int) {
            binding.imageView.layoutParams.width = size
            binding.imageView.layoutParams.height = size
        }
    }

    class ListCardViewHolder(private val binding: LayoutListCardBinding) :
        GameListViewHolder(binding) {
        private var gameModel: GameItem.ListItem? = null

        override fun onBind(gameItem: GameItem) {
            gameModel = gameItem as? GameItem.ListItem
            with(binding) {
                title.text = gameModel?.title
                category.text = gameModel?.category
                score.text = gameModel?.score
            }

            Glide.with(binding.imageView.context)
                .load(gameModel?.url)
                .into(binding.imageView)
        }
    }

    class SmallImageCardViewHolder(private val binding: LayoutSmallImageCardBinding) :
        GameListViewHolder(binding) {

        private var gameModel: GameItem.SmallImageItem? = null
        override fun onBind(gameItem: GameItem) {
            gameModel = gameItem as? GameItem.SmallImageItem
            with(binding) {
                title.text = gameModel?.title
                score.text = gameModel?.score
            }

            Glide.with(binding.imageView.context)
                .load(gameModel?.url)
                .into(binding.imageView)
        }
    }
}