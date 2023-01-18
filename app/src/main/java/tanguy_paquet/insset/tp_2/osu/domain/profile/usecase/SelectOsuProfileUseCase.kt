package tanguy_paquet.insset.tp_2.osu.domain.profile.usecase

import androidx.lifecycle.LiveData
import tanguy_paquet.insset.tp_2.osu.data.profile.model.ProfileRoom
import tanguy_paquet.insset.tp_2.osu.data.profile.repository.ProfileRepositoryImpl
import tanguy_paquet.insset.tp_2.osu.domain.profile.repository.ProfileRepository

class SelectOsuProfileUseCase {
    private val profileRepository: ProfileRepository by lazy {
        ProfileRepositoryImpl()
    }

    fun selectOsuProfile(username: String): LiveData<List<ProfileRoom>> {
        return profileRepository.selectOsuProfile(username)
    }
}