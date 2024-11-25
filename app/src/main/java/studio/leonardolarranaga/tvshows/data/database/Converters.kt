package studio.leonardolarranaga.tvshows.data.database

import androidx.room.TypeConverter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import studio.leonardolarranaga.tvshows.data.model.tvShow.shared.Image
import studio.leonardolarranaga.tvshows.data.model.tvShow.shared.Rating

class Converters {
    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    // Image
    private val imageAdapter = moshi.adapter(Image::class.java)
    @TypeConverter
    fun imageToJson(image: Image): String = imageAdapter.toJson(image)
    @TypeConverter
    fun jsonToImage(json: String): Image? = imageAdapter.fromJson(json)

    // Rating
    private val ratingAdapter = moshi.adapter(Rating::class.java)
    @TypeConverter
    fun ratingToJson(rating: Rating): String = ratingAdapter.toJson(rating)
    @TypeConverter
    fun jsonToRating(json: String): Rating? = ratingAdapter.fromJson(json)

    // List<String>
    @TypeConverter
    fun listToJson(list: List<String>): String = list.joinToString(",")
    @TypeConverter
    fun jsonToList(json: String): List<String> = json.split(",")
}