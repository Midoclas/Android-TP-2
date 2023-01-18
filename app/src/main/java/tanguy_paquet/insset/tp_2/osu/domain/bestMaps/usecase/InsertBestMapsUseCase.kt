package tanguy_paquet.insset.tp_2.osu.domain.bestMaps.usecase

import tanguy_paquet.insset.tp_2.osu.data.bestMaps.repository.BestMapsRepositoryImpl
import tanguy_paquet.insset.tp_2.osu.domain.bestMaps.repository.BestMapsRepository

class InsertBestMapsUseCase {
    private val bestMapsRepository: BestMapsRepository by lazy {
        BestMapsRepositoryImpl()
    }

    suspend fun insertBestMaps(user_id: String) {
        bestMapsRepository.insertBestMaps(user_id)
    }
}