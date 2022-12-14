package tanguy_paquet.insset.tp_2.viewmodel

import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import tanguy_paquet.insset.tp_2.model.MyObjectForRecyclerView
import tanguy_paquet.insset.tp_2.model.ObjectDataHeaderSample
import tanguy_paquet.insset.tp_2.model.ObjectDataSample
import tanguy_paquet.insset.tp_2.repository.AndroidPriceRepository

class AndroidPriceViewModel:ViewModel() {
    private val androidVersionRepository: AndroidPriceRepository by lazy { AndroidPriceRepository() }
    val androidVersionList: LiveData<List<MyObjectForRecyclerView>> = androidVersionRepository.selectAllAndroidVersion().map { list ->
        list.toMyObjectForRecyclerView()
    }

    fun insertAndroidVersion(name: String, price: Int, url: String) {
        viewModelScope.launch(Dispatchers.IO) {
            androidVersionRepository.insertAndroidVersion(
                ObjectDataSample(name, price, url)
            )
        }
    }

    fun deleteAllAndroidVersion() {
        viewModelScope.launch(Dispatchers.IO) {
            androidVersionRepository.deleteAllAndroidVersion()
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