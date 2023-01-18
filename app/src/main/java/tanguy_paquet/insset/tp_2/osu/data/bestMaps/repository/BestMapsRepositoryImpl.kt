package tanguy_paquet.insset.tp_2.osu.data.bestMaps.repository

import androidx.lifecycle.LiveData
import tanguy_paquet.insset.tp_2.architecture.OsuApplication
import tanguy_paquet.insset.tp_2.architecture.RetrofitBuilder
import tanguy_paquet.insset.tp_2.osu.data.bestMaps.mapper.toRoom
import tanguy_paquet.insset.tp_2.osu.data.bestMaps.model.BestMapsRoom
import tanguy_paquet.insset.tp_2.osu.domain.bestMaps.repository.BestMapsRepository

class BestMapsRepositoryImpl: BestMapsRepository {

    private val mBestMapsDao =
        OsuApplication.instance.mApplicationDatabase.mBestMapsDao()

    override fun selectBestMaps(user_id: String): LiveData<List<BestMapsRoom>> {
        return mBestMapsDao.selectBestMapsByUserId(user_id)
    }

    override suspend fun insertBestMaps(user_id: String) {
        return mBestMapsDao.insert(RetrofitBuilder.BestMapsCall().getBestMaps(user_id).toRoom())
    }

    override fun deleteAllBestMaps() {
        mBestMapsDao.deleteAll()
    }

    override suspend fun setBeatmapsetId(beatmap_id: String) {
        mBestMapsDao.updateBeatmapsetid(beatmap_id, RetrofitBuilder.BestMapsCall().getBeatmapsetid(beatmap_id)[0].toString())
    }
}

