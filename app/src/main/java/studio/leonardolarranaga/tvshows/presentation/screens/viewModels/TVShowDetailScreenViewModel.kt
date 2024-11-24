package studio.leonardolarranaga.tvshows.presentation.screens.viewModels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import studio.leonardolarranaga.tvshows.data.api.TVShowsDataSource
import studio.leonardolarranaga.tvshows.data.model.tvShow.embededCast.TVShowWithCast
import studio.leonardolarranaga.tvshows.presentation.app.navigation.TVShowDetail

data class TVShowDetailScreenState(
    val isLoading: Boolean = false,
    val tvShow: TVShowWithCast? = null,
    val errorMessage: String? = null
)

class TVShowDetailScreenViewModel(
    savedStateHandle: SavedStateHandle
): ViewModel() {
    private val id = savedStateHandle.toRoute<TVShowDetail>().tvShowId

    private val _state = MutableStateFlow(TVShowDetailScreenState())
    val state = _state.asStateFlow()

    private val dataSource = TVShowsDataSource

    init {
        fetchTVShow()
    }

    fun fetchTVShow() = viewModelScope.launch {
        dataSource.getTVShow(id).collect { state ->
            _state.value = state
        }
    }
}