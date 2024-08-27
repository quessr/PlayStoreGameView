package com.quessr.playstore_gameview

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import androidx.annotation.AttrRes
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.quessr.playstore_gameview.common.constants.GameItemConstants
import com.quessr.playstore_gameview.model.GameItem

class GameListView @JvmOverloads constructor(
    context: Context,
    attr: AttributeSet? = null,
    @AttrRes defStyleAttr: Int = 0
) : LinearLayout(context, attr, defStyleAttr) {
    private var cardType: Int = 0
    private var spanCount: Int = 3

    private val adapter: GameListAdapter by lazy {
        GameListAdapter(cardType)
    }
    private val recyclerView: RecyclerView by lazy {
        RecyclerView(context).apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            this.adapter = this@GameListView.adapter
            layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
        }
    }

    init {
        context.theme.obtainStyledAttributes(attr, R.styleable.GameListView, 0, 0).apply {
            try {
                cardType = getInt(R.styleable.GameListView_cardType, 0)
                if (cardType == 1) {
                    spanCount = getInt(R.styleable.GameListView_spanCount, 3)
                }
            } finally {
                recycle()
            }
        }
        addView(recyclerView)
        applyCustomOptions(cardType)
        PagerSnapHelper().attachToRecyclerView(recyclerView)
    }

    fun submitList(games: List<GameItem>) {
        adapter.submitList(games)
    }

    private fun applyCustomOptions(type: Int) {
        when (type) {
            GameItemConstants.ITEM_BIG_IMAGE_CARD -> {
                //TODO BigImageCard 옵션 적용
            }

            GameItemConstants.ITEM_LIST_CARD -> {
                //TODO ListCard 옵션 적용

                // ListCard 옵션 적용 - 가로로 여러 줄을 생성
                recyclerView.layoutManager =
                    GridLayoutManager(context, spanCount, GridLayoutManager.HORIZONTAL, false)
            }

            GameItemConstants.ITEM_SMALL_IMAGE_CARD -> {
                //TODO SmallImageCard 옵션 적용
            }
        }
    }
}