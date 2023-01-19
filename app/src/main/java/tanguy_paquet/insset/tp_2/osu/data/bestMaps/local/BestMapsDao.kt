package tanguy_paquet.insset.tp_2.osu.data.bestMaps.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import tanguy_paquet.insset.tp_2.osu.data.bestMaps.model.BestMapsRoom

@Dao
interface BestMapsDao {
    @Query("SELECT * FROM bestmap_table ORDER BY pp DESC")
    fun selectBestMaps(): LiveData<List<BestMapsRoom>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(androidVersion: List<BestMapsRoom>)

    @Query("UPDATE bestmap_table SET beatmapset_id = :beatmapset_id, title = :title, artist = :artist WHERE beatmap_id = :beatmap_id")
    fun setMoreData(beatmap_id: String, beatmapset_id: String, title: String, artist: String)

    @Query("DELETE FROM bestmap_table")
    fun deleteAll()
}