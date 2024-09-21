package com.laioffer.spotify.ui.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.laioffer.spotify.datamodel.Section
import com.laioffer.spotify.repository.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: HomeRepository
): ViewModel() { //due to the need to handle configuration change, we need the ViewModel to handle state
    //data model
    private val _uiState = MutableStateFlow(HomeUiState(feed = emptyList(), isLoading = true))
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    // event
    fun fetchHomeScreen() {
        // coroutine scope
        viewModelScope.launch { // coroutine
            val sections = repository.getHomeSections()  //IO
            _uiState.value = HomeUiState(
                feed = sections,
                isLoading = false) // still main for following
        }
        Log.d("HomeViewModel", "${_uiState.value}")
    }
}

data class HomeUiState(val feed: List<Section>, val isLoading: Boolean)