package com.quessr.playstoregameview

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.gson.Gson
import com.quessr.playstore_gameview.GameListView
import com.quessr.playstore_gameview.model.GameItem
import com.quessr.playstoregameview.data.datasource.response.GameResponse

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val jsonReader = assets.open("googleplay_game_action_30.json").reader()
        val jsonString = jsonReader.readText()

        Log.d("MainActivity", "jsonString : $jsonString")
        jsonReader.close()

        val gameResponse = Gson().fromJson(jsonString, GameResponse::class.java)
        Log.d("MainActivity", "menu : $gameResponse")

        val bigImageGameListView =
            findViewById<GameListView>(com.quessr.playstore_gameview.R.id.bigImageGameListView)
        val bigImageGameList = mutableListOf<GameItem.BigImageItem>()

        gameResponse.content.forEachIndexed { index, gameItem ->
            bigImageGameList.add(
                GameItem.BigImageItem(
                    id = gameItem.id.toString(),
                    title = gameItem.title,
                    developer = gameItem.developer,
                    url = gameItem.url,
                    bannerUrl = gameItem.url,
                    categoryTitle = "액션 게임"
                )
            )
        }

        bigImageGameListView.submitList(bigImageGameList)

    }
}