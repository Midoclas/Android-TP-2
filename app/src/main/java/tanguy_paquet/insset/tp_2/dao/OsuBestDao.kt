package tanguy_paquet.insset.tp_2.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import tanguy_paquet.insset.tp_2.model.OsuBeatmapsetidRetrofit
import tanguy_paquet.insset.tp_2.model.OsuBest

@Dao
interface OsuBestDao {


    @Query("SELECT * FROM map_table ORDER BY pp ASC")
    fun selectAll(): LiveData<List<OsuBest>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(androidVersion: List<OsuBest>)

    @Query("UPDATE map_table SET beatmapset_id = :beatmapset_id WHERE beatmap_id = :beatmap_id")
    fun updateBeatmapsetid(beatmap_id: String, beatmapset_id: String)

    @Query("DELETE FROM map_table")
    fun deleteAll()
}
