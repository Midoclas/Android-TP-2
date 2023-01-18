package tanguy_paquet.insset.tp_2.osu.data.bestMaps.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import tanguy_paquet.insset.tp_2.osu.data.bestMaps.model.BestMapsRoom

@Dao
interface BestMapsDao {
    @Query("SELECT * FROM map_table ORDER BY pp DESC")
    fun selectAll(): LiveData<List<BestMapsRoom>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(androidVersion: List<BestMapsRoom>)

    @Query("UPDATE map_table SET beatmapset_id = :beatmapset_id WHERE beatmap_id = :beatmap_id")
    fun updateBeatmapsetid(beatmap_id: String, beatmapset_id: String)

    @Query("DELETE FROM map_table")
    fun deleteAll()
}