package tanguy_paquet.insset.tp_2.osu.view.profile.viewModel

import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import tanguy_paquet.insset.tp_2.osu.domain.profile.usecase.DeleteAllOsuProfile
import tanguy_paquet.insset.tp_2.osu.domain.profile.usecase.GetUserIdByUsernameUseCase
import tanguy_paquet.insset.tp_2.osu.domain.profile.usecase.InsertOsuProfileUseCase
import tanguy_paquet.insset.tp_2.osu.domain.profile.usecase.SelectOsuProfileUseCase
import tanguy_paquet.insset.tp_2.osu.view.profile.mapper.fromDomainToUi
import tanguy_paquet.insset.tp_2.osu.view.profile.model.ProfileUi
import tanguy_paquet.insset.tp_2.osu.view.profile.model.UserIdUi

class ProfileViewModel:ViewModel() {
    private val deleteAllOsuProfile: DeleteAllOsuProfile by lazy { DeleteAllOsuProfile() }
    private val insertOsuProfileUseCase: InsertOsuProfileUseCase by lazy { InsertOsuProfileUseCase() }
    private val selectOsuProfileUseCase: SelectOsuProfileUseCase by lazy { SelectOsuProfileUseCase() }
    private val getUserIdByUsernameUseCase: GetUserIdByUsernameUseCase by lazy { GetUserIdByUsernameUseCase() }

    fun mProfileLiveData(username: String): LiveData<List<ProfileUi>> {
        return selectOsuProfileUseCase.selectOsuProfile(username).map {
            it.fromDomainToUi()
        }
    }

    fun getUserIdByUsername(username: String): LiveData<List<UserIdUi>> {
        return getUserIdByUsernameUseCase.getUserIdByUsername(username).map {
            it.fromDomainToUi()
        }
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