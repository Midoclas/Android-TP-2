package tanguy_paquet.insset.tp_2.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import tanguy_paquet.insset.tp_2.model.BestUi
import tanguy_paquet.insset.tp_2.model.OsuBest
import tanguy_paquet.insset.tp_2.repository.BestRepository

class BestViewModel: ViewModel() {
    private val mBestRepository: BestRepository by lazy { BestRepository() }

    var mBestLiveData: LiveData<List<BestUi>> =
    mBestRepository.selectAllBest().map {
        it.setAllBeatmapset()
        it.toUi()
    }

    fun fetch() {
        viewModelScope.launch(Dispatchers.IO) {
            mBestRepository.fetch()
        }
    }

    fun insertOsuBest(user_id: String) {
        viewModelScope.launch(Dispatchers.IO) {
            mBestRepository.insertOsuProfile(user_id)
        }
    }

    fun deleteAllBest() {
        viewModelScope.launch(Dispatchers.IO) {
            mBestRepository.deleteAllBest()
        }
    }

    private fun List<OsuBest>.setAllBeatmapset() {
        asSequence().forEach {
            viewModelScope.launch(Dispatchers.IO){
                mBestRepository.setBeatmapsetId(it.beatmap_id)
            }
        }
    }
    private fun List<OsuBest>.toUi(): List<BestUi> {
        var result = asSequence().map {
            BestUi(
                beatmap_id = it.beatmap_id,
                score = it.score,
                maxcombo = it.maxcombo,
                count50 = it.count50,
                count100 = it.count100,
                count300 = it.count300,
                countmiss = it.countmiss,
                perfect = it.perfect,
                enabled_mods = it.enabled_mods,
                date = it.date,
                rank = it.rank,
                pp = it.pp,
                beatmapset_id = it.beatmapset_id
            )
        }.toList()

        //result.add(HeaderUi("Profile"))
        return result
    }

}


