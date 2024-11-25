package studio.leonardolarranaga.tvshows.presentation.screens.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import studio.leonardolarranaga.tvshows.TVShowsApplication
import studio.leonardolarranaga.tvshows.data.database.TVShowDAO
import studio.leonardolarranaga.tvshows.data.model.tvShow.TVShow

data class FavoritesScreenState(
    val favorites: List<TVShow> = emptyList()
)

class FavoritesScreenViewModel(
    private val tvShowDAO: TVShowDAO
): ViewModel() {
    private val _state = MutableStateFlow(FavoritesScreenState())
    val state = _state.asStateFlow()

    init {
        getFavorites()
    }

    private fun getFavorites() {
        viewModelScope.launch(Dispatchers.IO) {
            tvShowDAO.getTVShows().collect { favorites ->
                _state.value = _state.value.copy(favorites = favorites)
            }
        }
    }

    fun removeFavorite(tvShowId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            tvShowDAO.delete(id = tvShowId)
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as TVShowsApplication)
                FavoritesScreenViewModel(application.database.tvShowDao())
            }
        }
    }
}