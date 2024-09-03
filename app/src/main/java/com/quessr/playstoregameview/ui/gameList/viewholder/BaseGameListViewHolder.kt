package com.quessr.playstoregameview.ui.gameList.viewholder

import android.content.Context
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import androidx.viewbinding.ViewBinding
import com.quessr.playstore_gameview.model.GameItem

abstract class BaseGameListViewHolder<T : GameItem, VB : ViewBinding>(binding: VB) :
    ViewHolder(binding.root) {

    protected val context: Context = binding.root.context
    open fun onBind(model: T) {}
}