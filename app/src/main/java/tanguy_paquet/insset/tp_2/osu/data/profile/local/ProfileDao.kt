package tanguy_paquet.insset.tp_2.osu.data.profile.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import tanguy_paquet.insset.tp_2.osu.data.profile.model.ProfileRoom
import tanguy_paquet.insset.tp_2.osu.data.profile.model.UserIdRoom

@Dao
interface ProfileDao {
    @Query("SELECT * FROM profile_table WHERE username = :username")
    fun selectProfileByusername(username: String): LiveData<List<ProfileRoom>>

    @Query("SELECT user_id FROM profile_table WHERE username = :username")
    fun getUserIdByUsername(username: String): LiveData<List<UserIdRoom>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(androidVersion: List<ProfileRoom>)


    @Query("DELETE FROM profile_table")
    fun deleteAll()
}