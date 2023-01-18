package tanguy_paquet.insset.tp_2.osu.domain.bestMaps.usecase

import tanguy_paquet.insset.tp_2.osu.data.bestMaps.repository.BestMapsRepositoryImpl
import tanguy_paquet.insset.tp_2.osu.domain.bestMaps.repository.BestMapsRepository

class SetBeatmapsetIdUseCase {
    private val bestMapsRepository: BestMapsRepository by lazy {
        BestMapsRepositoryImpl()
    }

    suspend fun setBeatmapsetId(user_id: String) {
        bestMapsRepository.setBeatmapsetId(user_id)
    }
}