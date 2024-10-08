package com.quessr.playstore_gameview.viewholder

import android.util.Log
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.bumptech.glide.Glide
import com.quessr.playstore_gameview.common.constants.ImageSizeConstants
import com.quessr.playstore_gameview.databinding.LayoutBigImageFeaturedCardBinding
import com.quessr.playstore_gameview.databinding.LayoutBigImagePromoCardBinding
import com.quessr.playstore_gameview.databinding.LayoutListCardBinding
import com.quessr.playstore_gameview.databinding.LayoutSmallImageCardBinding
import com.quessr.playstore_gameview.model.GameItem

sealed class GameListViewHolder(binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {

    open fun onBind(gameItem: GameItem) {}
    class BigImagePromoCardViewHolder(private val binding: LayoutBigImagePromoCardBinding) :
        GameListViewHolder(binding) {
        private var gameModel: GameItem.BigImagePromoItem? = null
        override fun onBind(gameItem: GameItem) {
            gameModel = gameItem as? GameItem.BigImagePromoItem
            with(binding) {
                title.text = gameModel?.title
                developer.text = gameModel?.developer
            }

            Glide.with(binding.ivBanner.context)
                .load(gameModel?.bannerUrl)
                .into(binding.ivBanner)

            Glide.with(binding.imageView.context)
                .load(gameModel?.url)
                .into(binding.imageView)
        }

        fun setImageViewSize(size: Int) {
            binding.imageView.layoutParams.width = size
            binding.imageView.layoutParams.height = size
        }

        fun setButtonVisibility(size: Int) {
            Log.d("GameListAdapter", "setButtonVisibility called with size: $size")
            binding.btnInstall.isVisible = size == ImageSizeConstants.SIZE_SMALL
        }

        fun setTitleVisibility(visibility: Int) {
            Log.d("GameListAdapter", "visibility: $visibility")
            if (visibility == TITLE_VISIBLE) binding.tvCategoryTitle.isVisible else {
                binding.tvCategoryTitle.isVisible = false
                // MarginTop을 0으로 설정
                val params = binding.cardView.layoutParams as ViewGroup.MarginLayoutParams
                params.topMargin = 0
                binding.cardView.layoutParams = params
            }

        }
    }

    class BigImageFeaturedCardViewHolder(private val binding: LayoutBigImageFeaturedCardBinding) :
        GameListViewHolder(binding) {
        private var gameModel: GameItem.BigImageFeaturedItem? = null

        override fun onBind(gameItem: GameItem) {
            gameModel = gameItem as? GameItem.BigImageFeaturedItem
            Log.d("GameListAdapter", "BigImageFeaturedCardViewHolder")

            with(binding) {
                title.text = gameModel?.title
                category.text = gameModel?.category.toString()
                score.text = gameModel?.score
            }

            Glide.with(binding.ivBanner.context)
                .load(gameModel?.url)
                .into(binding.ivBanner)

            Glide.with(binding.imageView.context)
                .load(gameModel?.url)
                .into(binding.imageView)
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

    companion object {
        private var TITLE_VISIBLE = 1
        private var TITLE_GONE = 2
    }
}