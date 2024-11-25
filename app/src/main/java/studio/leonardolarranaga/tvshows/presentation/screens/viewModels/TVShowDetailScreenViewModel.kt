package studio.leonardolarranaga.tvshows.presentation.screens.viewModels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.navigation.toRoute
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import studio.leonardolarranaga.tvshows.TVShowsApplication
import studio.leonardolarranaga.tvshows.data.api.TVShowsDataSource
import studio.leonardolarranaga.tvshows.data.database.TVShowDAO
import studio.leonardolarranaga.tvshows.data.model.tvShow.TVShow
import studio.leonardolarranaga.tvshows.data.model.tvShow.embededCast.TVShowWithCast
import studio.leonardolarranaga.tvshows.presentation.app.navigation.TVShowDetail

data class TVShowDetailScreenState(
    val isLoading: Boolean = false,
    val tvShow: TVShowWithCast? = null,
    val errorMessage: String? = null,
    val isFavorite: Boolean = false
)

class TVShowDetailScreenViewModel(
    savedStateHandle: SavedStateHandle,
    private val tvShowDAO: TVShowDAO
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
            if (state.tvShow != null) {
                getTVShowAsFavorite()
            }
        }
    }

    private fun getTVShowAsFavorite() {
        viewModelScope.launch(Dispatchers.IO) {
            tvShowDAO.getTVShow(id).collect { tvShow ->
                with(_state) {
                    value = value.copy(isFavorite = tvShow != null)
                }
            }
        }
    }

    private fun addTVShowToFavorites() = viewModelScope.launch(Dispatchers.IO) {
        if (_state.value.tvShow != null) {
            val tvShow = TVShow(
                id = _state.value.tvShow!!.id,
                name = _state.value.tvShow!!.name,
                image = _state.value.tvShow!!.image,
                rating = _state.value.tvShow!!.rating,
                genres = _state.value.tvShow!!.genres,
            )
            tvShowDAO.insert(tvShow)
            getTVShowAsFavorite()
        }
    }

    private fun deleteTVShowFromFavorites() = viewModelScope.launch(Dispatchers.IO) {
        if (_state.value.tvShow?.id != null) {
            tvShowDAO.delete(id = _state.value.tvShow?.id!!)
            getTVShowAsFavorite()
        }
    }

    fun toggleFavorite() = viewModelScope.launch(Dispatchers.IO) {
        if (_state.value.isFavorite) deleteTVShowFromFavorites()
        else addTVShowToFavorites()
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as TVShowsApplication)
                TVShowDetailScreenViewModel(
                    this.createSavedStateHandle(),
                    application.database.tvShowDao()
                )
            }
        }
    }
}