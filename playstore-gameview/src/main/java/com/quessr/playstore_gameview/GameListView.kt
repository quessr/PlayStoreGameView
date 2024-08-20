package com.quessr.playstore_gameview

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import androidx.annotation.AttrRes
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.quessr.playstore_gameview.model.GameListModel

class GameListView @JvmOverloads constructor(
    context: Context,
    attr: AttributeSet? = null,
    @AttrRes defStyleAttr: Int = 0
) : LinearLayout(context, attr, defStyleAttr) {
    private var cardType: Int = 0
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
            } finally {
                recycle()
            }
        }
        addView(recyclerView)
    }

    fun submitList(games: List<GameListModel>) {
        adapter.submitList(games)
    }

    private fun applyCustomOptions(type: Int) {
        when (type) {
            0 -> {
                //TODO BigImageCard 옵션 적용
            }

            1 -> {
                //TODO ListCard 옵션 적용
            }

            2 -> {
                //TODO SmallImageCard 옵션 적용
            }
        }
    }
}