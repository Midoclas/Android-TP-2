package tanguy_paquet.insset.tp_2.osu.domain.bestMaps.repository

import androidx.lifecycle.LiveData
import tanguy_paquet.insset.tp_2.osu.data.bestMaps.model.BestMapsRoom

interface BestMapsRepository {

    fun selectBestMaps(): LiveData<List<BestMapsRoom>>

    suspend fun insertBestMaps(user_id: String)

    fun deleteAllBestMaps()

    suspend fun setMoreData(beatmap_id: String)
}