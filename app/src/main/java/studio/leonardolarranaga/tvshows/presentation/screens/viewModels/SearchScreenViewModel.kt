package studio.leonardolarranaga.tvshows.presentation.screens.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import studio.leonardolarranaga.tvshows.data.api.TVShowsDataSource
import studio.leonardolarranaga.tvshows.data.model.tvShow.searchTVShow.SearchTVShow

data class SearchScreenState(
    val isLoading: Boolean = false,
    val tvShows: List<SearchTVShow> = emptyList(),
    val errorMessage: String? = null,
    val searchText: String = "",
    val hasSearched: Boolean = false
)

class SearchScreenViewModel: ViewModel() {
    private val _state = MutableStateFlow(SearchScreenState())
    val state = _state.asStateFlow()

    private val dataSource = TVShowsDataSource

    fun searchTVShowByName() = viewModelScope.launch{
        dataSource.searchTVShowByName(_state.value.searchText).collect { state ->
            _state.value = state
        }
    }

    fun updateSearchText(text: String) {
        _state.value = _state.value.copy(searchText = text)
    }
}