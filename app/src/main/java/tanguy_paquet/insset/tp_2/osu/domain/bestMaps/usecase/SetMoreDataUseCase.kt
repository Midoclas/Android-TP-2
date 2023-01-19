package tanguy_paquet.insset.tp_2.osu.domain.bestMaps.usecase

import tanguy_paquet.insset.tp_2.osu.data.bestMaps.repository.BestMapsRepositoryImpl
import tanguy_paquet.insset.tp_2.osu.domain.bestMaps.repository.BestMapsRepository

class SetMoreDataUseCase {
    private val bestMapsRepository: BestMapsRepository by lazy {
        BestMapsRepositoryImpl()
    }

    suspend fun setMoreData(user_id: String) {
        bestMapsRepository.setMoreData(user_id)
    }
}