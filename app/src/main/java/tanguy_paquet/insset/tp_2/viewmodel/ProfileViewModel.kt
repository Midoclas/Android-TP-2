package tanguy_paquet.insset.tp_2.viewmodel

import android.annotation.SuppressLint
import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import tanguy_paquet.insset.tp_2.model.*
import tanguy_paquet.insset.tp_2.repository.ProfileRepository

class ProfileViewModel:ViewModel() {
    private val mProfileRepository: ProfileRepository by lazy { ProfileRepository() }

    var mProfileLiveData: LiveData<List<ProfileUi>> =
    mProfileRepository.selectOsuProfile().map {
        it.toUi()
    }

    fun fetch() {
        viewModelScope.launch(Dispatchers.IO) {
            mProfileRepository.fetch()
        }
    }

    fun insertOsuProfile(id_user: String) {
        viewModelScope.launch(Dispatchers.IO) {
            mProfileRepository.insertOsuProfile(id_user)
        }
    }

    fun deleteProfile() {
        viewModelScope.launch(Dispatchers.IO) {
            mProfileRepository.deleteAllOsuProfile()
        }
    }
}

private fun List<OsuProfile>.toUi(): List<ProfileUi> {
    var result = asSequence().map {
        ProfileUi(
            user_id = it.user_id,
            username = it.username,
            level = it.level,
            accuracy = it.accuracy,
            count_rank_ss = it.count_rank_ss,
            count_rank_ssh = it.count_rank_ssh,
            count_rank_s = it.count_rank_s,
            count_rank_sh = it.count_rank_sh,
            count_rank_a = it.count_rank_a,
            country = it.country,
            pp_rank = it.pp_rank,
            pp_country_rank = it.pp_country_rank
        )
    }.toList()

    //result.add(HeaderUi("Profile"))
    return result
}