package tanguy_paquet.insset.tp_2.osu.data.profile.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import tanguy_paquet.insset.tp_2.osu.data.profile.model.ProfileRoom

@Dao
interface ProfileDao {
    @Query("SELECT * FROM profile_table ORDER BY user_id ASC")
    fun selectAll(): LiveData<List<ProfileRoom>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(androidVersion: List<ProfileRoom>)


    @Query("DELETE FROM profile_table")
    fun deleteAll()
}