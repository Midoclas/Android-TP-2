package tanguy_paquet.insset.tp_2.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import tanguy_paquet.insset.tp_2.model.OsuProfile

@Dao
interface OsuDao {


    @Query("SELECT * FROM profile_table ORDER BY user_id ASC")
    fun selectAll(): LiveData<List<OsuProfile>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(androidVersion: List<OsuProfile>)


    @Query("DELETE FROM profile_table")
    fun deleteAll()
}
