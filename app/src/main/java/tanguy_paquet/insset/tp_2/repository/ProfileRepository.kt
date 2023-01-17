package tanguy_paquet.insset.tp_2.repository

import androidx.lifecycle.LiveData
import tanguy_paquet.insset.tp_2.architecture.DefineDatabase
import tanguy_paquet.insset.tp_2.architecture.RetrofitBuilder
import tanguy_paquet.insset.tp_2.model.OsuProfile
import tanguy_paquet.insset.tp_2.model.OsuProfileRetrofit

class ProfileRepository {

    private val mOsuProfileDao =
        DefineDatabase.instance.mApplicationDatabase.mOsuProfileDao()

    fun selectAllOsuProfile(): LiveData<List<OsuProfile>> {
        return mOsuProfileDao.selectAll()
    }

    suspend fun fetch() {
        RetrofitBuilder.call().getOsuProfile("4717982")
    }

    suspend fun insertOsuProfileByUsername(username: String) {
        mOsuProfileDao.insert(RetrofitBuilder.call().getOsuProfile(username).setProfile())
    }
    suspend fun insertOsuProfileByUserId(user_id: String) {
        mOsuProfileDao.insert(RetrofitBuilder.call().getOsuProfile(user_id).setProfile())
    }


    fun deleteAllOsuProfile() {
        mOsuProfileDao.deleteAll()
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