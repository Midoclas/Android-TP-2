package tanguy_paquet.insset.tp_2.osu.domain.profile.usecase

import tanguy_paquet.insset.tp_2.osu.data.profile.repository.ProfileRepositoryImpl
import tanguy_paquet.insset.tp_2.osu.domain.profile.repository.ProfileRepository

class InsertOsuProfileUseCase {
    private val profileRepository: ProfileRepository by lazy {
        ProfileRepositoryImpl()
    }

    suspend fun InsertOsuProfile(id_user: String) {
        return profileRepository.insertOsuProfile(id_user)
    }
}