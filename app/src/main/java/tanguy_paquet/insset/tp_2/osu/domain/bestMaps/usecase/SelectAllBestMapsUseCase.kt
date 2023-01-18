package tanguy_paquet.insset.tp_2.osu.domain.bestMaps.usecase

import androidx.lifecycle.LiveData
import tanguy_paquet.insset.tp_2.osu.data.bestMaps.model.BestMapsRoom
import tanguy_paquet.insset.tp_2.osu.data.bestMaps.repository.BestMapsRepositoryImpl
import tanguy_paquet.insset.tp_2.osu.domain.bestMaps.repository.BestMapsRepository

class SelectAllBestMapsUseCase {
    private val bestMapsRepository: BestMapsRepository by lazy {
        BestMapsRepositoryImpl()
    }

    fun selectAllBestMaps(): LiveData<List<BestMapsRoom>> {
        return bestMapsRepository.selectAllBestMaps()
    }
}