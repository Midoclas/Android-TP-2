package tanguy_paquet.insset.tp_2.osu.domain.bestMaps.usecase

import tanguy_paquet.insset.tp_2.osu.data.bestMaps.repository.BestMapsRepositoryImpl
import tanguy_paquet.insset.tp_2.osu.domain.bestMaps.repository.BestMapsRepository

class DeleteAllBestMapsUseCase {
    private val bestMapsRepository: BestMapsRepository by lazy {
        BestMapsRepositoryImpl()
    }

    fun deleteAllBestMaps() {
        bestMapsRepository.deleteAllBestMaps()
    }
}