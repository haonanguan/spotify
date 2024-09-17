package com.laioffer.spotify.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.laioffer.spotify.R
import dagger.hilt.android.AndroidEntryPoint

// 1. send event : load data
// 2. ViewModel load data
// 3. ViewModel -> networkApi.getFeed()
// 4. ViewModel.feed()
// 5. HomeFragment observer ViewModel.feed
// 6. HomeFragment update UI

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (viewModel.uiState.value.isLoading) {
            viewModel.fetchHomeScreen()
        }
    }
}