package tanguy_paquet.insset.tp_2.repository

import android.util.Log
import androidx.lifecycle.LiveData
import retrofit2.Retrofit
import tanguy_paquet.insset.tp_2.architecture.DefineDatabase
import tanguy_paquet.insset.tp_2.architecture.RetrofitBuilder
import tanguy_paquet.insset.tp_2.model.OsuBeatmapsetidRetrofit
import tanguy_paquet.insset.tp_2.model.OsuBest
import tanguy_paquet.insset.tp_2.model.OsuBestRetrofit

class BestRepository {

    private val mOsuBestDao =
        DefineDatabase.instance.mApplicationDatabase.mOsuBestDao()

    fun selectAllBest(): LiveData<List<OsuBest>> {
        return mOsuBestDao.selectAll()
    }

    suspend fun fetch() {
        RetrofitBuilder.call().getOsuBest("4717982")
    }

    suspend fun insertOsuProfile(user_id: String) {
        mOsuBestDao.insert(RetrofitBuilder.call().getOsuBest(user_id).setProfile())
    }


    fun deleteAllBest() {
        mOsuBestDao.deleteAll()
    }

    suspend fun setBeatmapsetId(beatmap_id: String) {
        mOsuBestDao.updateBeatmapsetid(beatmap_id, RetrofitBuilder.call().getBeatmapsetid(beatmap_id)[0].toString())
    }
}

fun ArrayList<OsuBestRetrofit>.setProfile(): List<OsuBest> {
    return map { eachItem ->
        OsuBest(
            beatmap_id = eachItem.beatmap_id,
            score = eachItem.score,
            maxcombo = eachItem.maxcombo,
            count50 = eachItem.count50,
            count100 = eachItem.count100,
            count300 = eachItem.count300,
            countmiss = eachItem.countmiss,
            perfect = eachItem.perfect,
            enabled_mods = eachItem.enabled_mods,
            date = eachItem.date,
            rank = eachItem.rank,
            pp = eachItem.pp
        )
    }
}