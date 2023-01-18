package tanguy_paquet.insset.tp_2.osu.data.profile.repository

import androidx.lifecycle.LiveData
import tanguy_paquet.insset.tp_2.architecture.OsuApplication
import tanguy_paquet.insset.tp_2.architecture.RetrofitBuilder
import tanguy_paquet.insset.tp_2.osu.data.profile.mapper.toRoom
import tanguy_paquet.insset.tp_2.osu.data.profile.model.ProfileRoom
import tanguy_paquet.insset.tp_2.osu.domain.profile.repository.ProfileRepository

class ProfileRepositoryImpl: ProfileRepository {

    private val mProfileDao =
        OsuApplication.instance.mApplicationDatabase.mProfileDao()

    override fun selectOsuProfile(): LiveData<List<ProfileRoom>> {
        return mProfileDao.selectAll()
    }

    override suspend fun insertOsuProfile(user_id: String) {
        mProfileDao.insert(RetrofitBuilder.ProfileCall().getProfile(user_id).toRoom())
    }


    override fun deleteAllOsuProfile() {
        mProfileDao.deleteAll()
    }
}