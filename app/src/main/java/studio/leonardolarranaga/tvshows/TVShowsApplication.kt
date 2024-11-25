package studio.leonardolarranaga.tvshows

import android.app.Application
import studio.leonardolarranaga.tvshows.data.database.TVShowDatabase

class TVShowsApplication: Application() {
    lateinit var database: TVShowDatabase

    override fun onCreate() {
        super.onCreate()
        database = TVShowDatabase.getInstance(this)
    }
}