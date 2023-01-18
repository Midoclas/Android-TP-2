package tanguy_paquet.insset.tp_2.osu.domain.profile.usecase

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import tanguy_paquet.insset.tp_2.osu.data.profile.model.ProfileRoom
import tanguy_paquet.insset.tp_2.osu.data.profile.model.UserIdRoom
import tanguy_paquet.insset.tp_2.osu.data.profile.repository.ProfileRepositoryImpl
import tanguy_paquet.insset.tp_2.osu.domain.profile.repository.ProfileRepository
import tanguy_paquet.insset.tp_2.osu.view.profile.model.ProfileUi

class GetUserIdByUsernameUseCase {
    private val profileRepository: ProfileRepository by lazy {
        ProfileRepositoryImpl()
    }

    fun getUserIdByUsername(username: String): LiveData<List<UserIdRoom>> {
        return profileRepository.getUserIdByUsername(username)
    }
}