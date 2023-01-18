package tanguy_paquet.insset.tp_2.osu.domain.bestMaps.repository

import androidx.lifecycle.LiveData
import tanguy_paquet.insset.tp_2.osu.data.bestMaps.model.BestMapsRoom

interface BestMapsRepository {

    fun selectBestMaps(user_id: String): LiveData<List<BestMapsRoom>>

    suspend fun insertBestMaps(user_id: String)

    fun deleteAllBestMaps()

    suspend fun setBeatmapsetId(beatmpa_id: String)
}