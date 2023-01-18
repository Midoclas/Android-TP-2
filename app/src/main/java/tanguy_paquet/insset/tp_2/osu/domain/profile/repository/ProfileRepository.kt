package tanguy_paquet.insset.tp_2.osu.domain.profile.repository

import androidx.lifecycle.LiveData
import tanguy_paquet.insset.tp_2.osu.data.profile.model.ProfileRoom

interface ProfileRepository {

    fun selectOsuProfile(): LiveData<List<ProfileRoom>>

    suspend fun insertOsuProfile(user_id: String)

    fun deleteAllOsuProfile()
}