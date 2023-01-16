package tanguy_paquet.insset.tp_2.repository

import android.util.Log
import androidx.lifecycle.LiveData
import tanguy_paquet.insset.tp_2.architecture.DefineDatabase
import tanguy_paquet.insset.tp_2.architecture.RetrofitBuilder
import tanguy_paquet.insset.tp_2.model.OsuProfile
import tanguy_paquet.insset.tp_2.model.OsuProfileRetrofit

class ProfileRepository {

    private val mOsuDao =
        DefineDatabase.instance.mApplicationDatabase.mOsuDao()

    fun selectAllOsuProfile(): LiveData<List<OsuProfile>> {
        return mOsuDao.selectAll()
    }

    suspend fun fetch() {
        val test = RetrofitBuilder.call().getOsuProfileByUserId("4717982")
        Log.d("username", "fetch() called $test")
    }

    suspend fun insertOsuProfileByUsername(username: String) {
        mOsuDao.insert(RetrofitBuilder.call().getOsuProfileByUsername(username).setProfile())
    }
    suspend fun insertOsuProfileByUserId(user_id: String) {
        mOsuDao.insert(RetrofitBuilder.call().getOsuProfileByUserId(user_id).setProfile())
    }


    fun deleteAllOsuProfile() {
        mOsuDao.deleteAll()
    }
}

private fun ArrayList<OsuProfileRetrofit>.setProfile(): List<OsuProfile> {
    return map { eachItem ->
        OsuProfile(
            user_id = eachItem.user_id,
            username = eachItem.username,
            level = eachItem.level,
            accuracy = eachItem.accuracy,
            count_rank_ss = eachItem.count_rank_ss,
            count_rank_ssh = eachItem.count_rank_ssh,
            count_rank_s = eachItem.count_rank_s,
            count_rank_sh = eachItem.count_rank_sh,
            count_rank_a = eachItem.count_rank_a,
            country = eachItem.country,
            pp_rank = eachItem.pp_rank,
            pp_country_rank = eachItem.pp_country_rank
        )
    }
}