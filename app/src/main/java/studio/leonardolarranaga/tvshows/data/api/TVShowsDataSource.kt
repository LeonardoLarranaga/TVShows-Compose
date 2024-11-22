package studio.leonardolarranaga.tvshows.data.api

import android.util.Log
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import studio.leonardolarranaga.tvshows.presentation.screens.viewModels.TVShowsScreenState

object TVShowsDataSource {
    private val service = TVShowsRetrofitClient.tvShowsAPIService

    fun getTVShows(): Flow<TVShowsScreenState> = flow {
        var state = TVShowsScreenState(isLoading = true)
        emit(state)

        try {
            val response = service.getTVShows()
            Log.d("TVShowsDataSource", response.toString())
            if (!response.isSuccessful) throw Exception(response.errorBody().toString())

            val body = response.body() ?: throw Exception("No Data Found")
            state = state.copy(tvShows = body.take(50))
            emit(state)
        } catch (e: Exception) {
            emit(state.copy(errorMessage = e.message))
        } finally {
            emit(state.copy(isLoading = false))
        }
    }
}