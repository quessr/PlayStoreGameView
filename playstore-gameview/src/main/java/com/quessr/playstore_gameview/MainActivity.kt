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

        val bigImageUrls = listOf(
            "https://play-lh.googleusercontent.com/gBwyUx08H_DS15bxol5uU3wXPUDGMidMTy2IvpmX5r9SxPfFGOec94-Uu5qUhMD6lrOW2vQdL80=w648-h364-rw",
            "https://play-lh.googleusercontent.com/QeOA9G1vaOcjh2CQTdfGfqIf3edbFMNvkscRZvAmK9Re8kYwJ9iijm2KQuWYTPm3lDp5=w648-h364-rw",
            "https://play-lh.googleusercontent.com/YkM1SfZeNI2HBaN6_ZsPOaQ7Ci84emoeBwzrwGF5Ey45Bu-HDyOFa18hEiIC5jH7LRn22l_p_GU=w648-h364-rw",
            "https://play-lh.googleusercontent.com/S5z-S6I4-pMVFrVM6ZBTfTtHD0e9aFoLmfcchsZ6hNOeOEBp0GIGyzEa2TZB-Quof9ChJ5QvhvKR=w648-h364-rw",
            "https://play-lh.googleusercontent.com/MunvOcZ4l0E_7kyt_EE2wG9mJx4wtuqfjQn_cHdEaY7VBRJxlepC-wfoxoLhh2nttBb_ADQA8zs=w648-h364-rw"
        )

        val smallImageUrls = listOf(
            "https://play-lh.googleusercontent.com/9smJnY23-ntQoNXtGL_CFUQS5-ym1m13BCM8gPTCXfkAjzG2VmZ-sia7IDajDEHXmtlH=s256-rw",
            "https://play-lh.googleusercontent.com/MLMMicHGYrboSoLZH2ZwO8-sFw1Io8DLx-1R3ISyio2n04AuEib2w0_8afqjh2ggqIM=s256-rw",
            "https://play-lh.googleusercontent.com/4f7AD-TiE_9c2W2Su2BbJ4g_Ug6jtA16zXyDQx5DxqKJrrBCQM_Y_ODozfiwFgQnog=s256-rw",
            "https://play-lh.googleusercontent.com/UP0MYbhlYrnvyBndS2KyrFK1mU2GRIvjaO66XqWml_1eRxKNftw9mKWsoC7Sfgzp1jU=s256-rw",
            "https://play-lh.googleusercontent.com/0OgcAFU7Lw1tjgwsPM2qMaW2SnQux-sliLoLmbz4jn6lmi36bOkm5AFwztlCHatvGtOx=s256-rw"
        )

        val listImageUrls = listOf(
            "https://play-lh.googleusercontent.com/5YzJ_bSQGDQVMO-VITHteT-wvlr8u-YYsCV8NiEhJ7s1DKZrOscX-9LnKdx6jeOFSQ=s64-rw",
            "https://play-lh.googleusercontent.com/Bm43g1yixHgWfEKowoWlgqIkDAmFaxDZlytr50pp_KrvFLmyW5rumlUKLTaaUGEP39M=s64-rw",
            "https://play-lh.googleusercontent.com/n6zetdjA1AiIHP5HJYCdlos1w3771t7dJg0ZqYsCiHkh4jHLGdIWpyMYWHcEjKyxSS4=s64-rw",
            "https://play-lh.googleusercontent.com/I7W78YpvMi6Ai9WIwTUgRdWTqPgIeSxtZ6uR2cCI6_TJ-g3sFEeo2ouRMq8a7bqZqgQ=s64-rw",
            "https://play-lh.googleusercontent.com/Q71eI_PcSsab6iJId24DRUHMzdIKnJWmxZSHEsC6paFFMfZZmju-XRGI8aE2-h6ytWI=s64-rw"
        )

        val bigImageGameList = mutableListOf<GameItem.BigImageItem>()
        val smallImageGameList = mutableListOf<GameItem.SmallImageItem>()
        val listImageGameList = mutableListOf<GameItem.ListItem>()

        repeat(30) { index ->
            bigImageGameList.add(
                GameItem.BigImageItem(
                    id = "$index",
                    title = "게임 $index",
                    developer = "개발자 $index",
                    url = bigImageUrls[index % bigImageUrls.size],  // URL 리스트에서 반복적으로 가져옴
                    bannerUrl = bigImageUrls[(index + 1) % bigImageUrls.size],
                )
            )

            smallImageGameList.add(
                GameItem.SmallImageItem(
                    id = "${index + 10}",
                    title = "게임 $index",
                    score = "2.${index + 1}",
                    url = smallImageUrls[index % smallImageUrls.size]  // URL 리스트에서 반복적으로 가져옴
                )
            )

            listImageGameList.add(
                GameItem.ListItem(
                    id = "${index + 20}",
                    title = "앱 $index",
                    category = "카테고리 $index",
                    score = "4.${index + 1}",
                    url = listImageUrls[index % listImageUrls.size]  // URL 리스트에서 반복적으로 가져옴
                )
            )
        }


//        val bigImageGameList = listOf(
//            GameItem.BigImageItem(
//                "1",
//                "콜로사트론",
//                "Best Developer",
//                url = "https://image.winudf.com/v2/image1/Y29tLmhhbGZicmljay5jb2xvc3NhdHJvbl9pY29uXzE2OTEwNTAyMzJfMDIz/icon.png?w=160&fakeurl=1",
//                bannerUrl = "https://image.winudf.com/v2/image1/Y29tLmhhbGZicmljay5jb2xvc3NhdHJvbl9pY29uXzE2OTEwNTAyMzJfMDIz/icon.png?w=160&fakeurl=1"
//            ),
//            GameItem.BigImageItem(
//                "2",
//                "하늘 방어: 전쟁 의무",
//                "Top Developer",
//                url = "https://image.winudf.com/v2/image1/Y29tLmhvcnVzLnNreS5kZWZlbnNlX2ljb25fMTcxODAzOTc4MV8wNzE/icon.png?w=160&fakeurl=1",
//                bannerUrl = "https://image.winudf.com/v2/image1/Y29tLmhvcnVzLnNreS5kZWZlbnNlX2ljb25fMTcxODAzOTc4MV8wNzE/icon.png?w=160&fakeurl=1"
//            ),
//            GameItem.BigImageItem(
//                "1",
//                "콜로사트론",
//                "Best Developer",
//                url = "https://image.winudf.com/v2/image1/Y29tLmhhbGZicmljay5jb2xvc3NhdHJvbl9pY29uXzE2OTEwNTAyMzJfMDIz/icon.png?w=160&fakeurl=1",
//                bannerUrl = "https://image.winudf.com/v2/image1/Y29tLmhhbGZicmljay5jb2xvc3NhdHJvbl9pY29uXzE2OTEwNTAyMzJfMDIz/icon.png?w=160&fakeurl=1"
//            ),
//            GameItem.BigImageItem(
//                "2",
//                "하늘 방어: 전쟁 의무",
//                "Top Developer",
//                url = "https://image.winudf.com/v2/image1/Y29tLmhvcnVzLnNreS5kZWZlbnNlX2ljb25fMTcxODAzOTc4MV8wNzE/icon.png?w=160&fakeurl=1",
//                bannerUrl = "https://image.winudf.com/v2/image1/Y29tLmhvcnVzLnNreS5kZWZlbnNlX2ljb25fMTcxODAzOTc4MV8wNzE/icon.png?w=160&fakeurl=1"
//            ),
//        )
//        val smallImageGameList = listOf(
//            GameItem.SmallImageItem(
//                "3",
//                "고양이 오피스: 타이쿤 게임",
//                "2.7",
//                "https://play-lh.googleusercontent.com/0OgcAFU7Lw1tjgwsPM2qMaW2SnQux-sliLoLmbz4jn6lmi36bOkm5AFwztlCHatvGtOx=s64-rw"
//            ),
//            GameItem.SmallImageItem(
//                "4",
//                "블러드 헬벤더:각성",
//                "2.7",
//                "https://play-lh.googleusercontent.com/SZYZFZkhqQ103gz4yUU-mUVqRUb0jccMsGJX3th2zZ7_Lpn36Z70wMYAAxLEl1ECSw=s64-rw"
//            ),
//            GameItem.SmallImageItem(
//                "3",
//                "고양이 오피스: 타이쿤 게임",
//                "2.7",
//                "https://play-lh.googleusercontent.com/0OgcAFU7Lw1tjgwsPM2qMaW2SnQux-sliLoLmbz4jn6lmi36bOkm5AFwztlCHatvGtOx=s64-rw"
//            ),
//            GameItem.SmallImageItem(
//                "4",
//                "블러드 헬벤더:각성",
//                "2.7",
//                "https://play-lh.googleusercontent.com/SZYZFZkhqQ103gz4yUU-mUVqRUb0jccMsGJX3th2zZ7_Lpn36Z70wMYAAxLEl1ECSw=s64-rw"
//            ),
//            GameItem.SmallImageItem(
//                "3",
//                "고양이 오피스: 타이쿤 게임",
//                "2.7",
//                "https://play-lh.googleusercontent.com/0OgcAFU7Lw1tjgwsPM2qMaW2SnQux-sliLoLmbz4jn6lmi36bOkm5AFwztlCHatvGtOx=s64-rw"
//            ),
//            GameItem.SmallImageItem(
//                "4",
//                "블러드 헬벤더:각성",
//                "2.7",
//                "https://play-lh.googleusercontent.com/SZYZFZkhqQ103gz4yUU-mUVqRUb0jccMsGJX3th2zZ7_Lpn36Z70wMYAAxLEl1ECSw=s64-rw"
//            )
//        )
//        val listImageGameList = listOf(
//            GameItem.ListItem(
//                "0",
//                "네이버페이",
//                "금융",
//                "3.6",
//                "https://play-lh.googleusercontent.com/-REeRpbsL3nQTjoDfRzxvqgdqwtp6Pflbx8P3aqvCQsed5zJabGZ4qYC01G_q-9svn4=s64-rw"
//            ), GameItem.ListItem(
//                "0",
//                "TikTok Lite  포인트, 쿠폰, 영상",
//                "동영상 플레이어/편집기",
//                "4.7",
//                "https://play-lh.googleusercontent.com/0mrWcoPNYR2CHHbvRlek_cuhoXf4fU26k-Tjdh9-0sUMl2viIvEn5ig8yI04lewvz7pU=s64-rw"
//            ),
//            GameItem.ListItem(
//                "0",
//                "AliExpress",
//                "쇼핑",
//                "4.5",
//                "https://play-lh.googleusercontent.com/luLha_idSPcj2X1lF0GvIOuf4ODegCSuSDbPBSc2DXxrwaXCLRc5sWDZteSH0I44gmdG=s64-rw"
//            ),
//            GameItem.ListItem(
//                "0",
//                "ChatGPT",
//                "생산성",
//                "4.8",
//                "https://play-lh.googleusercontent.com/6qi3w4uqKaD1c-CBdkkfO6IL0lH4OoCTEdiX0oYbLFxwfvxu1t8vuwHcagdYSFmFKmI=s64-rw"
//            ),
//            GameItem.ListItem(
//                "0",
//                "네이버페이",
//                "금융",
//                "3.6",
//                "https://play-lh.googleusercontent.com/-REeRpbsL3nQTjoDfRzxvqgdqwtp6Pflbx8P3aqvCQsed5zJabGZ4qYC01G_q-9svn4=s64-rw"
//            ), GameItem.ListItem(
//                "0",
//                "TikTok Lite  포인트, 쿠폰, 영상",
//                "동영상 플레이어/편집기",
//                "4.7",
//                "https://play-lh.googleusercontent.com/0mrWcoPNYR2CHHbvRlek_cuhoXf4fU26k-Tjdh9-0sUMl2viIvEn5ig8yI04lewvz7pU=s64-rw"
//            ),
//            GameItem.ListItem(
//                "0",
//                "AliExpress",
//                "쇼핑",
//                "4.5",
//                "https://play-lh.googleusercontent.com/luLha_idSPcj2X1lF0GvIOuf4ODegCSuSDbPBSc2DXxrwaXCLRc5sWDZteSH0I44gmdG=s64-rw"
//            ),
//            GameItem.ListItem(
//                "0",
//                "ChatGPT",
//                "생산성",
//                "4.8",
//                "https://play-lh.googleusercontent.com/6qi3w4uqKaD1c-CBdkkfO6IL0lH4OoCTEdiX0oYbLFxwfvxu1t8vuwHcagdYSFmFKmI=s64-rw"
//            )
//        )


        bigImageGameListView.submitList(bigImageGameList)
        smallImageGameListView.submitList(smallImageGameList)
        listImageGameListView.submitList(listImageGameList)
    }
}