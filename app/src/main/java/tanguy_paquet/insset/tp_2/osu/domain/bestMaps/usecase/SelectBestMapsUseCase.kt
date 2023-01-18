package tanguy_paquet.insset.tp_2.osu.domain.bestMaps.usecase

import android.util.Log
import androidx.lifecycle.LiveData
import tanguy_paquet.insset.tp_2.osu.data.bestMaps.model.BestMapsRoom
import tanguy_paquet.insset.tp_2.osu.data.bestMaps.repository.BestMapsRepositoryImpl
import tanguy_paquet.insset.tp_2.osu.domain.bestMaps.repository.BestMapsRepository

class SelectBestMapsUseCase {
    private val bestMapsRepository: BestMapsRepository by lazy {
        BestMapsRepositoryImpl()
    }

    fun selectBestMaps(): LiveData<List<BestMapsRoom>> {
        return bestMapsRepository.selectBestMaps()
    }

}