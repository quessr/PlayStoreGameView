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
        val listImageGameListView = findViewById<GameListView>(R.id.listImageGameListView)

        val bigImageGameList = listOf(
            GameListModel.BigImageCard(
                "1",
                "콜로사트론",
                "Best Developer",
                url = "https://image.winudf.com/v2/image1/Y29tLmhhbGZicmljay5jb2xvc3NhdHJvbl9pY29uXzE2OTEwNTAyMzJfMDIz/icon.png?w=160&fakeurl=1",
                bannerUrl = "https://image.winudf.com/v2/image1/Y29tLmhhbGZicmljay5jb2xvc3NhdHJvbl9pY29uXzE2OTEwNTAyMzJfMDIz/icon.png?w=160&fakeurl=1"
            ),
            GameListModel.BigImageCard(
                "2",
                "하늘 방어: 전쟁 의무",
                "Top Developer",
                url = "https://image.winudf.com/v2/image1/Y29tLmhvcnVzLnNreS5kZWZlbnNlX2ljb25fMTcxODAzOTc4MV8wNzE/icon.png?w=160&fakeurl=1",
                bannerUrl = "https://image.winudf.com/v2/image1/Y29tLmhvcnVzLnNreS5kZWZlbnNlX2ljb25fMTcxODAzOTc4MV8wNzE/icon.png?w=160&fakeurl=1"
            ),
        )
        val smallImageGameList = listOf(
            GameListModel.SmallImageCard(
                "3",
                "고양이 오피스: 타이쿤 게임",
                "2.7",
                "https://play-lh.googleusercontent.com/0OgcAFU7Lw1tjgwsPM2qMaW2SnQux-sliLoLmbz4jn6lmi36bOkm5AFwztlCHatvGtOx=s64-rw"
            ),
            GameListModel.SmallImageCard(
                "4",
                "블러드 헬벤더:각성",
                "2.7",
                "https://play-lh.googleusercontent.com/SZYZFZkhqQ103gz4yUU-mUVqRUb0jccMsGJX3th2zZ7_Lpn36Z70wMYAAxLEl1ECSw=s64-rw"
            ),
            GameListModel.SmallImageCard(
                "3",
                "고양이 오피스: 타이쿤 게임",
                "2.7",
                "https://play-lh.googleusercontent.com/0OgcAFU7Lw1tjgwsPM2qMaW2SnQux-sliLoLmbz4jn6lmi36bOkm5AFwztlCHatvGtOx=s64-rw"
            ),
            GameListModel.SmallImageCard(
                "4",
                "블러드 헬벤더:각성",
                "2.7",
                "https://play-lh.googleusercontent.com/SZYZFZkhqQ103gz4yUU-mUVqRUb0jccMsGJX3th2zZ7_Lpn36Z70wMYAAxLEl1ECSw=s64-rw"
            ),
            GameListModel.SmallImageCard(
                "3",
                "고양이 오피스: 타이쿤 게임",
                "2.7",
                "https://play-lh.googleusercontent.com/0OgcAFU7Lw1tjgwsPM2qMaW2SnQux-sliLoLmbz4jn6lmi36bOkm5AFwztlCHatvGtOx=s64-rw"
            ),
            GameListModel.SmallImageCard(
                "4",
                "블러드 헬벤더:각성",
                "2.7",
                "https://play-lh.googleusercontent.com/SZYZFZkhqQ103gz4yUU-mUVqRUb0jccMsGJX3th2zZ7_Lpn36Z70wMYAAxLEl1ECSw=s64-rw"
            )
        )
        val listImageGameList = listOf(
            GameListModel.ListCard(
                "0",
                "네이버페이",
                "금융",
                "3.6",
                "https://play-lh.googleusercontent.com/-REeRpbsL3nQTjoDfRzxvqgdqwtp6Pflbx8P3aqvCQsed5zJabGZ4qYC01G_q-9svn4=s64-rw"
            ), GameListModel.ListCard(
                "0",
                "네이버페이",
                "금융",
                "3.6",
                "https://play-lh.googleusercontent.com/-REeRpbsL3nQTjoDfRzxvqgdqwtp6Pflbx8P3aqvCQsed5zJabGZ4qYC01G_q-9svn4=s64-rw"
            ),
            GameListModel.ListCard(
                "0",
                "네이버페이",
                "금융",
                "3.6",
                "https://play-lh.googleusercontent.com/-REeRpbsL3nQTjoDfRzxvqgdqwtp6Pflbx8P3aqvCQsed5zJabGZ4qYC01G_q-9svn4=s64-rw"
            ),
            GameListModel.ListCard(
                "0",
                "네이버페이",
                "금융",
                "3.6",
                "https://play-lh.googleusercontent.com/-REeRpbsL3nQTjoDfRzxvqgdqwtp6Pflbx8P3aqvCQsed5zJabGZ4qYC01G_q-9svn4=s64-rw"
            )
        )


        bigImageGameListView.submitList(bigImageGameList)
        smallImageGameListView.submitList(smallImageGameList)
        listImageGameListView.submitList(listImageGameList)
    }
}