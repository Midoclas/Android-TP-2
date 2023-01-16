package tanguy_paquet.insset.tp_2.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
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
    @PrimaryKey(autoGenerate = true)
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