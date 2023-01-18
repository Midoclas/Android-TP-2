package tanguy_paquet.insset.tp_2.osu.data.profile.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "profile_table")
data class ProfileRoom(
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

data class UserIdRoom(
    @ColumnInfo(name = "user_id")
    val user_id: String
) {
    override fun toString(): String = user_id
}
data class ProfileRetrofit(

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