package tanguy_paquet.insset.tp_2.osu.data.bestMaps.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "map_table")
data class BestMapsRoom (
    @ColumnInfo(name = "beatmap_id")
    val beatmap_id: String,

    @ColumnInfo(name = "beatmapset_id")
    val beatmapset_id: String = "0",

    @ColumnInfo(name = "score")
    val score: String,

    @ColumnInfo(name = "maxcombo")
    val maxcombo: String,

    @ColumnInfo(name = "count50")
    val count50: String,

    @ColumnInfo(name = "count100")
    val count100: String,

    @ColumnInfo(name = "count300")
    val count300: String,

    @ColumnInfo(name = "countmiss")
    val countmiss: String,

    @ColumnInfo(name = "perfect")
    val perfect: String,

    @ColumnInfo(name = "enabled_mods")
    val enabled_mods: String,

    @ColumnInfo(name = "user_id")
    val user_id: String,

    @ColumnInfo(name = "date")
    val date: String,

    @ColumnInfo(name = "rank")
    val rank: String,

    @ColumnInfo(name = "pp")
    val pp: String
) {
    @PrimaryKey(autoGenerate = false)
    var id: Long = beatmap_id.toLong()
}

data class BestMapsRetrofit(
    @SerializedName("beatmap_id")
    val beatmap_id: String,

    @SerializedName("beatmapset_id")
    val beatmapset_id: String = "0",

    @SerializedName("score")
    val score: String,

    @SerializedName("maxcombo")
    val maxcombo: String,

    @SerializedName("count50")
    val count50: String,

    @SerializedName("count100")
    val count100: String,

    @SerializedName("count300")
    val count300: String,

    @SerializedName("countmiss")
    val countmiss: String,

    @SerializedName("perfect")
    val perfect: String,

    @SerializedName("enabled_mods")
    val enabled_mods: String,

    @SerializedName("user_id")
    val user_id: String,

    @SerializedName("date")
    val date: String,

    @SerializedName("rank")
    val rank: String,

    @SerializedName("pp")
    val pp: String
)

data class BeatmapsetidRetrofit(
    @SerializedName("beatmapset_id")
    val beatmapset_id: String,
) {
    override fun toString(): String = beatmapset_id
}