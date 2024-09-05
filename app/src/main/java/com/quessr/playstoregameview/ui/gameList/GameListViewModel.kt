package com.quessr.playstoregameview.ui.gameList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.quessr.playstoregameview.data.model.GameListItem

class GameListViewModel : ViewModel() {
    private val _gameListItem = MutableLiveData<List<GameListItem>>()
    val gameListItem: LiveData<List<GameListItem>> = _gameListItem

    fun setGameListItem(list: List<GameListItem>) {
        _gameListItem.value = list
    }
}