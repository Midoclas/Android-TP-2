package tanguy_paquet.insset.tp_2.repository

import androidx.lifecycle.LiveData
import tanguy_paquet.insset.tp_2.architecture.DefineDatabase
import tanguy_paquet.insset.tp_2.architecture.RetrofitBuilder
import tanguy_paquet.insset.tp_2.model.OsuProfile

class profileRepository {

    private val mOsuDao =
        DefineDatabase.instance.mApplicationDatabase.mOsuDao()

    fun selectAllAndroidVersion(): LiveData<List<OsuProfile>> {
        return mOsuDao.selectAll()
    }


    suspend fun insertOsuProfile(username: String) {
        mOsuDao.insert(RetrofitBuilder.call().getOsuProfileByUsername(username).setProfile())
    }


    fun deleteAllOsuProfile() {
        mOsuDao.deleteAll()
    }
}

private fun OsuProfile.setProfile(): OsuProfile {
    return OsuProfile(
        user_id = user_id,
        username = username,
        level = level,
        accuracy = accuracy,
        count_rank_ss = count_rank_ss,
        count_rank_ssh = count_rank_ssh,
        count_rank_s = count_rank_s,
        count_rank_sh = count_rank_sh,
        count_rank_a = count_rank_a,
        country = country,
        pp_rank = pp_rank,
        pp_country_rank = pp_country_rank
    )
}