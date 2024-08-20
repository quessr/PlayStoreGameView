package com.quessr.playstore_gameview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.quessr.playstore_gameview.model.GameListModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bigImageGameListView = findViewById<GameListView>(R.id.bigImageGameListView)
        val smallImageGameListView = findViewById<GameListView>(R.id.smallImageGameListView)

        val bigImageGameList = listOf(
            GameListModel.BigImageCard("1", "콜로사트론", "Best Developer", "https://example.com/image1.jpg"),
            GameListModel.BigImageCard("2", "하늘 방어: 전쟁 의무", "Top Developer", "https://example.com/image2.jpg"),
        )
        val smallImageGameList = listOf(
            GameListModel.SmallImageCard("3", "small 하늘 방어: 전쟁 의무", "Top Developer", "https://example.com/image2.jpg"),
            GameListModel.SmallImageCard("4", "small 콜로사트론", "Top Developer", "https://example.com/image2.jpg")
        )

        bigImageGameListView.submitList(bigImageGameList)
        smallImageGameListView.submitList(smallImageGameList)
    }
}