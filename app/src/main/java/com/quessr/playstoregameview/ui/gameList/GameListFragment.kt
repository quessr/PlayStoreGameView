package com.quessr.playstoregameview.ui.gameList

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.google.gson.Gson
import com.quessr.playstore_gameview.GameListView
import com.quessr.playstore_gameview.model.GameItem
import com.quessr.playstoregameview.R
import com.quessr.playstoregameview.data.datasource.response.GameResponse
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

        val jsonReader = requireActivity().assets.open("googleplay_game_action_30.json").reader()
        val jsonString = jsonReader.readText()
        jsonReader.close()

        val gameResponse = Gson().fromJson(jsonString, GameResponse::class.java)
        Log.d("GameListFragment", "menu : $gameResponse")

        val bigImageGameList = mutableListOf<GameItem.BigImageItem>()

        gameResponse.content.forEachIndexed { index, gameItem ->
            bigImageGameList.add(
                GameItem.BigImageItem(
                    id = gameItem.id.toString(),
                    title = gameItem.title,
                    developer = gameItem.developer,
                    url = gameItem.url,
                    bannerUrl = gameItem.url,
                )
            )
        }

        viewModel.setBigImageGameList(bigImageGameList)
        gameListAdapter.submitList(bigImageGameList as List<GameItem>?)

    }
}


