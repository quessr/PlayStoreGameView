package com.quessr.playstoregameview.ui.gameList

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.google.gson.Gson
import com.quessr.playstore_gameview.model.GameItem
import com.quessr.playstoregameview.data.datasource.response.GameResponse
import com.quessr.playstoregameview.data.model.GameListItem
import com.quessr.playstoregameview.databinding.FragmentGameListBinding

class GameListFragment : Fragment() {
    private var _binding: FragmentGameListBinding? = null
    private val binding get() = _binding!!
    private lateinit var gameListAdapter: GameListAdapter
    private val viewModel: GameListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGameListBinding.inflate(inflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("GameListFragment", "GameListFragment")

        gameListAdapter = GameListAdapter(viewModel)
        binding.rvGameList.adapter = gameListAdapter

        initViewModel()
        setupData()
    }

    private fun initViewModel() {
        viewModel.gameListItem.observe(viewLifecycleOwner) { gameListItems ->
            gameListAdapter.submitList(gameListItems)
        }
    }

    private fun setupData() {
        val bigImagePromoGameList =
            loadGameItemsFromAsset("googleplay_game_action_30.json") { gameItem ->
                GameItem.BigImagePromoItem(
                    id = gameItem.id.toString(),
                    title = gameItem.title,
                    developer = gameItem.developer,
                    url = gameItem.url,
                    bannerUrl = gameItem.url
                )
            }

        val listChartGameList =
            loadGameItemsFromAsset("googleplay_game_well-rated_30.json") { gameItem ->
                GameItem.ListItem(
                    id = gameItem.id.toString(),
                    title = gameItem.title,
                    category = gameItem.category.toString(),
                    score = "${gameItem.score} ★",
                    url = gameItem.url
                )
            }

        val smallGameList =
            loadGameItemsFromAsset("googleplay_game_sports_30.json") { gameItem ->
                GameItem.SmallImageItem(
                    id = gameItem.id.toString(),
                    title = gameItem.title,
                    score = "${gameItem.score} ★",
                    url = gameItem.url
                )
            }

        val bigImageFeaturedGameList1 =
            loadGameItemsFromAsset("googleplay_game_board_30.json") { gameItem ->
                GameItem.BigImageFeaturedItem(
                    id = gameItem.id.toString(),
                    title = gameItem.title,
                    category = gameItem.category,
                    score = "${gameItem.score} ★",
                    url = gameItem.url,
                    bannerUrl = gameItem.url
                )
            }

        val bigImageFeaturedGameList2 =
            loadGameItemsFromAsset("googleplay_game_casual_30.json") { gameItem ->
                GameItem.BigImageFeaturedItem(
                    id = gameItem.id.toString(),
                    title = gameItem.title,
                    category = gameItem.category,
                    score = "${gameItem.score} ★",
                    url = gameItem.url,
                    bannerUrl = gameItem.url
                )
            }

        val bigImageFeaturedGameList3 =
            loadGameItemsFromAsset("googleplay_game_puzzle_30.json") { gameItem ->
                GameItem.BigImageFeaturedItem(
                    id = gameItem.id.toString(),
                    title = gameItem.title,
                    category = gameItem.category,
                    score = "${gameItem.score} ★",
                    url = gameItem.url,
                    bannerUrl = gameItem.url
                )
            }

        val data = listOf(
            GameListItem.Promo(
                id = "1",
                items = bigImagePromoGameList
            ),
            GameListItem.ListChart(
                id = "4",
                title = "인기 차트",
                items = listChartGameList
            ),
            GameListItem.Small(
                id = "5",
                title = "스포츠 게임",
                items = smallGameList
            ),
            GameListItem.Featured(
                id = "2",
                title = "보드 게임",
                items = bigImageFeaturedGameList1
            ),
            GameListItem.Featured(
                id = "3",
                title = "캐주얼 게임",
                items = bigImageFeaturedGameList2
            ),
            GameListItem.Featured(
                id = "4",
                title = "퍼즐 게임",
                items = bigImageFeaturedGameList3
            )
        )

        viewModel.setGameListItem(data)
    }

    private fun <T : GameItem> loadGameItemsFromAsset(
        fileName: String,
        mapToGameItem: (GameResponse.GameItem) -> T
    ): MutableList<T> {
        val jsonReader = requireActivity().assets.open(fileName).reader()
        val jsonString = jsonReader.readText()
        jsonReader.close()

        val gameResponse = Gson().fromJson(jsonString, GameResponse::class.java)

        val gameItemList = mutableListOf<T>()
        println("Content size: ${gameResponse.content.size}")

        gameResponse.content.forEach { gameItem ->
            gameItemList.add(mapToGameItem(gameItem))
        }
        return gameItemList
    }
}


