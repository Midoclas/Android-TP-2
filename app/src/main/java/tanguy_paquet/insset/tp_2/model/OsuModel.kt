package tanguy_paquet.insset.tp_2.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

sealed class MyObjectForRecyclerView(label: String)

data class HeaderUi(
    val header: String
) : MyObjectForRecyclerView(label = header)


data class ProfileUi(
    val user_id: String,
    val username: String,
    val level: String,
    val accuracy: String,
    val count_rank_ss: String,
    val count_rank_ssh: String,
    val count_rank_s: String,
    val count_rank_sh: String,
    val count_rank_a: String,
    val country: String,
    val pp_rank: String,
    val pp_country_rank: String
) : MyObjectForRecyclerView(label = user_id)

data class BestUi(
    val beatmap_id: String,
    val beatmapset_id: String,
    val score: String,
    val maxcombo: String,
    val count50: String,
    val count100: String,
    val count300: String,
    val countmiss: String,
    val perfect: String,
    val enabled_mods: String,
    val date: String,
    val rank: String,
    val pp: String
) : MyObjectForRecyclerView(label = beatmap_id)

@Entity(tableName = "map_table")
data class OsuBest (
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

data class OsuBestRetrofit(
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

    @SerializedName("date")
    val date: String,

    @SerializedName("rank")
    val rank: String,

    @SerializedName("pp")
    val pp: String
)

@Entity(tableName = "profile_table")
data class OsuProfile(
    @ColumnInfo(name = "user_id")
    val user_id: String,

    @ColumnInfo(name = "username")
    val username: String,

    @ColumnInfo(name = "level")
    val level: String,

    @ColumnInfo(name = "accuracy")
    val accuracy: String,

    @ColumnInfo(name = "count_rank_ss")
    val count_rank_ss: String,

    @ColumnInfo(name = "count_rank_ssh")
    val count_rank_ssh: String,

    @ColumnInfo(name = "count_rank_s")
    val count_rank_s: String,

    @ColumnInfo(name = "count_rank_sh")
    val count_rank_sh: String,

    @ColumnInfo(name = "count_rank_a")
    val count_rank_a: String,

    @ColumnInfo(name = "country")
    val country: String,

    @ColumnInfo(name = "pp_rank")
    val pp_rank: String,

    @ColumnInfo(name = "pp_country_rank")
    val pp_country_rank: String,
) {
    @PrimaryKey(autoGenerate = false)
    var id: Long = user_id.toLong()
}

data class OsuProfileRetrofit(
    
    @SerializedName("user_id")
    val user_id: String,

    
    @SerializedName("username")
    val username: String,

    
    @SerializedName("level")
    val level: String,

    
    @SerializedName("accuracy")
    val accuracy: String,

    
    @SerializedName("count_rank_ss")
    val count_rank_ss: String,

    
    @SerializedName("count_rank_ssh")
    val count_rank_ssh: String,

    
    @SerializedName("count_rank_s")
    val count_rank_s: String,

    
    @SerializedName("count_rank_sh")
    val count_rank_sh: String,

    
    @SerializedName("count_rank_a")
    val count_rank_a: String,

    
    @SerializedName("country")
    val country: String,

    
    @SerializedName("pp_rank")
    val pp_rank: String,

    
    @SerializedName("pp_country_rank")
    val pp_country_rank: String,
)

data class OsuBeatmapsetidRetrofit(
    @SerializedName("beatmapset_id")
    val beatmapset_id: String,
) {
    override fun toString(): String = beatmapset_id
}