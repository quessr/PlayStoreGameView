package com.quessr.playstore_gameview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.quessr.playstore_gameview.model.GameItem

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bigImageGameListView = findViewById<GameListView>(R.id.bigImageGameListView)
        val smallImageGameListView = findViewById<GameListView>(R.id.smallImageGameListView)
        val listImageGameListView = findViewById<GameListView>(R.id.listImageGameListView)

        val bigImageGameList = listOf(
            GameItem.BigImageItem(
                "1",
                "콜로사트론",
                "Best Developer",
                url = "https://image.winudf.com/v2/image1/Y29tLmhhbGZicmljay5jb2xvc3NhdHJvbl9pY29uXzE2OTEwNTAyMzJfMDIz/icon.png?w=160&fakeurl=1",
                bannerUrl = "https://image.winudf.com/v2/image1/Y29tLmhhbGZicmljay5jb2xvc3NhdHJvbl9pY29uXzE2OTEwNTAyMzJfMDIz/icon.png?w=160&fakeurl=1"
            ),
            GameItem.BigImageItem(
                "2",
                "하늘 방어: 전쟁 의무",
                "Top Developer",
                url = "https://image.winudf.com/v2/image1/Y29tLmhvcnVzLnNreS5kZWZlbnNlX2ljb25fMTcxODAzOTc4MV8wNzE/icon.png?w=160&fakeurl=1",
                bannerUrl = "https://image.winudf.com/v2/image1/Y29tLmhvcnVzLnNreS5kZWZlbnNlX2ljb25fMTcxODAzOTc4MV8wNzE/icon.png?w=160&fakeurl=1"
            ),
        )
        val smallImageGameList = listOf(
            GameItem.SmallImageItem(
                "3",
                "고양이 오피스: 타이쿤 게임",
                "2.7",
                "https://play-lh.googleusercontent.com/0OgcAFU7Lw1tjgwsPM2qMaW2SnQux-sliLoLmbz4jn6lmi36bOkm5AFwztlCHatvGtOx=s64-rw"
            ),
            GameItem.SmallImageItem(
                "4",
                "블러드 헬벤더:각성",
                "2.7",
                "https://play-lh.googleusercontent.com/SZYZFZkhqQ103gz4yUU-mUVqRUb0jccMsGJX3th2zZ7_Lpn36Z70wMYAAxLEl1ECSw=s64-rw"
            ),
            GameItem.SmallImageItem(
                "3",
                "고양이 오피스: 타이쿤 게임",
                "2.7",
                "https://play-lh.googleusercontent.com/0OgcAFU7Lw1tjgwsPM2qMaW2SnQux-sliLoLmbz4jn6lmi36bOkm5AFwztlCHatvGtOx=s64-rw"
            ),
            GameItem.SmallImageItem(
                "4",
                "블러드 헬벤더:각성",
                "2.7",
                "https://play-lh.googleusercontent.com/SZYZFZkhqQ103gz4yUU-mUVqRUb0jccMsGJX3th2zZ7_Lpn36Z70wMYAAxLEl1ECSw=s64-rw"
            ),
            GameItem.SmallImageItem(
                "3",
                "고양이 오피스: 타이쿤 게임",
                "2.7",
                "https://play-lh.googleusercontent.com/0OgcAFU7Lw1tjgwsPM2qMaW2SnQux-sliLoLmbz4jn6lmi36bOkm5AFwztlCHatvGtOx=s64-rw"
            ),
            GameItem.SmallImageItem(
                "4",
                "블러드 헬벤더:각성",
                "2.7",
                "https://play-lh.googleusercontent.com/SZYZFZkhqQ103gz4yUU-mUVqRUb0jccMsGJX3th2zZ7_Lpn36Z70wMYAAxLEl1ECSw=s64-rw"
            )
        )
        val listImageGameList = listOf(
            GameItem.ListItem(
                "0",
                "네이버페이",
                "금융",
                "3.6",
                "https://play-lh.googleusercontent.com/-REeRpbsL3nQTjoDfRzxvqgdqwtp6Pflbx8P3aqvCQsed5zJabGZ4qYC01G_q-9svn4=s64-rw"
            ), GameItem.ListItem(
                "0",
                "TikTok Lite  포인트, 쿠폰, 영상",
                "동영상 플레이어/편집기",
                "4.7",
                "https://play-lh.googleusercontent.com/0mrWcoPNYR2CHHbvRlek_cuhoXf4fU26k-Tjdh9-0sUMl2viIvEn5ig8yI04lewvz7pU=s64-rw"
            ),
            GameItem.ListItem(
                "0",
                "AliExpress",
                "쇼핑",
                "4.5",
                "https://play-lh.googleusercontent.com/luLha_idSPcj2X1lF0GvIOuf4ODegCSuSDbPBSc2DXxrwaXCLRc5sWDZteSH0I44gmdG=s64-rw"
            ),
            GameItem.ListItem(
                "0",
                "ChatGPT",
                "생산성",
                "4.8",
                "https://play-lh.googleusercontent.com/6qi3w4uqKaD1c-CBdkkfO6IL0lH4OoCTEdiX0oYbLFxwfvxu1t8vuwHcagdYSFmFKmI=s64-rw"
            ),
            GameItem.ListItem(
                "0",
                "네이버페이",
                "금융",
                "3.6",
                "https://play-lh.googleusercontent.com/-REeRpbsL3nQTjoDfRzxvqgdqwtp6Pflbx8P3aqvCQsed5zJabGZ4qYC01G_q-9svn4=s64-rw"
            ), GameItem.ListItem(
                "0",
                "TikTok Lite  포인트, 쿠폰, 영상",
                "동영상 플레이어/편집기",
                "4.7",
                "https://play-lh.googleusercontent.com/0mrWcoPNYR2CHHbvRlek_cuhoXf4fU26k-Tjdh9-0sUMl2viIvEn5ig8yI04lewvz7pU=s64-rw"
            ),
            GameItem.ListItem(
                "0",
                "AliExpress",
                "쇼핑",
                "4.5",
                "https://play-lh.googleusercontent.com/luLha_idSPcj2X1lF0GvIOuf4ODegCSuSDbPBSc2DXxrwaXCLRc5sWDZteSH0I44gmdG=s64-rw"
            ),
            GameItem.ListItem(
                "0",
                "ChatGPT",
                "생산성",
                "4.8",
                "https://play-lh.googleusercontent.com/6qi3w4uqKaD1c-CBdkkfO6IL0lH4OoCTEdiX0oYbLFxwfvxu1t8vuwHcagdYSFmFKmI=s64-rw"
            )
        )


        bigImageGameListView.submitList(bigImageGameList)
        smallImageGameListView.submitList(smallImageGameList)
        listImageGameListView.submitList(listImageGameList)
    }
}