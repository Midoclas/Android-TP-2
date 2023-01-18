package tanguy_paquet.insset.tp_2.osu.view.profile.viewModel

import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import tanguy_paquet.insset.tp_2.osu.domain.profile.usecase.DeleteAllOsuProfile
import tanguy_paquet.insset.tp_2.osu.domain.profile.usecase.InsertOsuProfileUseCase
import tanguy_paquet.insset.tp_2.osu.domain.profile.usecase.SelectOsuProfileUseCase
import tanguy_paquet.insset.tp_2.osu.view.profile.mapper.fromDomainToUi
import tanguy_paquet.insset.tp_2.osu.view.profile.model.ProfileUi

class ProfileViewModel:ViewModel() {
    private val deleteAllOsuProfile: DeleteAllOsuProfile by lazy { DeleteAllOsuProfile() }
    private val insertOsuProfileUseCase: InsertOsuProfileUseCase by lazy { InsertOsuProfileUseCase() }
    private val selectOsuProfileUseCase: SelectOsuProfileUseCase by lazy { SelectOsuProfileUseCase() }

    var mProfileLiveData: LiveData<List<ProfileUi>> =
        selectOsuProfileUseCase.selectOsuProfile().map {
        it.fromDomainToUi()
    }
    fun insertOsuProfile(id_user: String) {
        viewModelScope.launch(Dispatchers.IO) {
            insertOsuProfileUseCase.InsertOsuProfile(id_user)
        }
    }

    fun deleteProfile() {
        viewModelScope.launch(Dispatchers.IO) {
            deleteAllOsuProfile.deleteAllOsuProfile()
        }
    }
}