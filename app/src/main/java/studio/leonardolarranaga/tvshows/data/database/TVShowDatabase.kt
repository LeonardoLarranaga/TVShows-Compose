package studio.leonardolarranaga.tvshows.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import studio.leonardolarranaga.tvshows.data.model.tvShow.TVShow
import kotlin.concurrent.Volatile

@Database(entities = [TVShow::class], version = 1)
@TypeConverters(Converters::class)
abstract class TVShowDatabase: RoomDatabase() {
    abstract fun tvShowDao(): TVShowDAO

    companion object {
        private const val DATABASE_NAME = "tv_show_database"

        @Volatile
        private var instance: TVShowDatabase? = null

        fun getInstance(context: Context): TVShowDatabase {
            return instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context = context.applicationContext,
                    klass = TVShowDatabase::class.java,
                    name = DATABASE_NAME
                )
                    .build()
                    .also { instance = it }
            }
        }
    }
}