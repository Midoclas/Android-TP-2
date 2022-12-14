package tanguy_paquet.insset.tp_2.viewmodel

import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import tanguy_paquet.insset.tp_2.model.MyObjectForRecyclerView
import tanguy_paquet.insset.tp_2.model.ObjectDataHeaderSample
import tanguy_paquet.insset.tp_2.model.ObjectDataSample
import tanguy_paquet.insset.tp_2.repository.AndroidPriceRepository
import tanguy_paquet.insset.tp_2.repository.profileRepository

class ProfileViewModel:ViewModel() {
    private val ProfileRepository: ProfileRepository by lazy { ProfileRepository() }
    val androidVersionList: LiveData<List<MyObjectForRecyclerView>> = androidVersionRepository.selectAllAndroidVersion().map { list ->
        list.toMyObjectForRecyclerView()
    }

    fun insertOsuProfile(name: String) {
        viewModelScope.launch(Dispatchers.IO) {
            ProfileRepository.insertAndroidVersion(
                ProfileRepository.insertOsuProfile
            )
        }
    }

    fun deleteAllAndroidVersion() {
        viewModelScope.launch(Dispatchers.IO) {
            ProfileRepository.deleteAllAndroidVersion()
        }
    }
}

//Firebase authentication

private fun List<ObjectDataSample>.toMyObjectForRecyclerView(): List<MyObjectForRecyclerView> {
    val result = mutableListOf<MyObjectForRecyclerView>()

    groupBy {
        it.price >= 1000
    }.forEach { (iphone, items) ->
        val final = if (iphone) {"Iphone"} else {"Android"}
        result.add(ObjectDataHeaderSample(final))
        result.addAll(items)
    }
    return result
}