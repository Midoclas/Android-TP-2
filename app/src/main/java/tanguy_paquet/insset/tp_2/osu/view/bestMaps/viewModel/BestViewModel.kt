package tanguy_paquet.insset.tp_2.osu.view.bestMaps.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import tanguy_paquet.insset.tp_2.osu.data.bestMaps.model.BestMapsRoom
import tanguy_paquet.insset.tp_2.osu.domain.bestMaps.usecase.*
import tanguy_paquet.insset.tp_2.osu.view.bestMaps.mapper.fromDomainToUi
import tanguy_paquet.insset.tp_2.osu.view.bestMaps.model.BestMapsUi

class BestViewModel: ViewModel() {
    private val deleteAllBestMapsUseCase: DeleteAllBestMapsUseCase by lazy { DeleteAllBestMapsUseCase() }
    private val insertBestMapsUseCase: InsertBestMapsUseCase by lazy { InsertBestMapsUseCase() }
    private val selectBestMapsUseCase: SelectBestMapsUseCase by lazy { SelectBestMapsUseCase() }
    private val setBeatmapsetIdUseCase: SetBeatmapsetIdUseCase by lazy { SetBeatmapsetIdUseCase() }

    var mBestLiveData: LiveData<List<BestMapsUi>> =
    selectBestMapsUseCase.selectBestMaps().map {
        it.setAllBeatmapset()
        it.fromDomainToUi()
    }

    fun insertBestMaps(user_id: String) {
        viewModelScope.launch(Dispatchers.IO) {
            insertBestMapsUseCase.insertBestMaps(user_id)
        }
    }

    fun deleteAllBest() {
        viewModelScope.launch(Dispatchers.IO) {
            deleteAllBestMapsUseCase.deleteAllBestMaps()
        }
    }

    private fun List<BestMapsRoom>.setAllBeatmapset() {
        asSequence().forEach {
            viewModelScope.launch(Dispatchers.IO) {
                if (it.beatmapset_id == "0") {
                    setBeatmapsetIdUseCase.setBeatmapsetId(it.beatmap_id)
                }
            }
        }
    }
}


