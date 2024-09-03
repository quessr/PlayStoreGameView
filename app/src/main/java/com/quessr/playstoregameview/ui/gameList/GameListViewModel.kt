package com.quessr.playstoregameview.ui.gameList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.quessr.playstore_gameview.model.GameItem

class GameListViewModel: ViewModel() {
    private val _bigImageGameList = MutableLiveData<List<GameItem.BigImageItem>>()
    val bigImageGameList: LiveData<List<GameItem.BigImageItem>> = _bigImageGameList

    fun setBigImageGameList(list: List<GameItem.BigImageItem>) {
        _bigImageGameList.value = list
    }
}