package tanguy_paquet.insset.tp_2.osu.data.bestMaps.repository

import android.util.Log
import androidx.lifecycle.LiveData
import tanguy_paquet.insset.tp_2.architecture.OsuApplication
import tanguy_paquet.insset.tp_2.architecture.RetrofitBuilder
import tanguy_paquet.insset.tp_2.osu.data.bestMaps.mapper.toRoom
import tanguy_paquet.insset.tp_2.osu.data.bestMaps.model.BestMapsRoom
import tanguy_paquet.insset.tp_2.osu.domain.bestMaps.repository.BestMapsRepository

class BestMapsRepositoryImpl: BestMapsRepository {

    private val mBestMapsDao =
        OsuApplication.instance.mApplicationDatabase.mBestMapsDao()

    override fun selectBestMaps(): LiveData<List<BestMapsRoom>> {
        Log.d("Test", "selectBestMaps() called")
        return mBestMapsDao.selectBestMaps()
    }

    override suspend fun insertBestMaps(user_id: String) {
        Log.d("Test", "insertBestMaps() called with: user_id = $user_id")
        Log.d("Test", "insertBestMaps() called with: user_id = ${RetrofitBuilder.BestMapsCall().getBestMaps(user_id)}")
        return mBestMapsDao.insert(RetrofitBuilder.BestMapsCall().getBestMaps(user_id).toRoom())
    }

    override fun deleteAllBestMaps() {
        mBestMapsDao.deleteAll()
    }

    override suspend fun setMoreData(beatmap_id: String) {
        val data = RetrofitBuilder.BestMapsCall().setMoreData(beatmap_id)

        mBestMapsDao.setMoreData(beatmap_id, data[0].beatmapset_id, data[0].title, data[0].artist)
    }
}

