package studio.leonardolarranaga.tvshows.presentation.screens.viewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import studio.leonardolarranaga.tvshows.data.api.TVShowsDataSource
import studio.leonardolarranaga.tvshows.data.model.tvShow.TVShow

data class TVShowsScreenState(
    val isLoading: Boolean = false,
    val tvShows: List<TVShow> = emptyList(),
    val errorMessage: String? = null
)

class TVShowsScreenViewModel: ViewModel() {
    private val _state = MutableStateFlow(TVShowsScreenState())
    val state = _state.asStateFlow()

    private val dataSource = TVShowsDataSource

    init {
        fetchTVShows()
    }

    fun fetchTVShows() = viewModelScope.launch {
        Log.d("TVShowsScreenViewModel", "fetchTVShows()")
        dataSource.getTVShows().collect { state ->
            _state.update { state }
        }
    }
}