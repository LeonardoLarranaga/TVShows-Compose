package studio.leonardolarranaga.tvshows.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import studio.leonardolarranaga.tvshows.data.model.tvShow.TVShow

@Dao
interface TVShowDAO {
    @Query("SELECT * FROM TVShow")
    fun getTVShows(): Flow<List<TVShow>>

    @Query("SELECT * FROM TVShow WHERE id = :id")
    fun getTVShow(id: Int): Flow<TVShow?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(tvShow: TVShow)

    @Delete
    suspend fun delete(tvShow: TVShow)

    @Query("DELETE FROM TVShow WHERE id = :id")
    suspend fun delete(id: Int)
}