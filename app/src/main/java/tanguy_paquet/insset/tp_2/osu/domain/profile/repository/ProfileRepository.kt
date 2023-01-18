package tanguy_paquet.insset.tp_2.osu.domain.profile.repository

import androidx.lifecycle.LiveData
import tanguy_paquet.insset.tp_2.osu.data.profile.model.ProfileRoom
import tanguy_paquet.insset.tp_2.osu.data.profile.model.UserIdRoom
import tanguy_paquet.insset.tp_2.osu.view.profile.model.ProfileUi

interface ProfileRepository {

    fun selectOsuProfile(username: String): LiveData<List<ProfileRoom>>

    suspend fun insertOsuProfile(user_id: String)

    fun deleteAllOsuProfile()

    fun getUserIdByUsername(username: String): LiveData<List<UserIdRoom>>
}