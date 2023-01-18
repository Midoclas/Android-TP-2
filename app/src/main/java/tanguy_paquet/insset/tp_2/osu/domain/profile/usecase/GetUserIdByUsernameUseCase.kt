package tanguy_paquet.insset.tp_2.osu.domain.profile.usecase

import tanguy_paquet.insset.tp_2.osu.data.profile.repository.ProfileRepositoryImpl
import tanguy_paquet.insset.tp_2.osu.domain.profile.repository.ProfileRepository

class GetUserIdByUsernameUseCase {
    private val profileRepository: ProfileRepository by lazy {
        ProfileRepositoryImpl()
    }

    fun getUserIdByUsername(username: String) {
        profileRepository.getUserIdByUsername(username)
    }
}