package tanguy_paquet.insset.tp_2.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import tanguy_paquet.insset.tp_2.architecture.DefineDatabase
import tanguy_paquet.insset.tp_2.model.LocalDataSourceSample
import tanguy_paquet.insset.tp_2.model.ObjectDataSample

class AndroidPriceRepository {

    private val mAndroidVersionDao =
        DefineDatabase.instance.mApplicationDatabase.mAndroidPriceDao()

    fun selectAllAndroidVersion(): LiveData<List<ObjectDataSample>> {
        return mAndroidVersionDao.selectAll().map { list ->
            list.toObjectDataSample()
        }
    }


    fun insertAndroidVersion(objectDataSample: ObjectDataSample) {
        mAndroidVersionDao.insert(objectDataSample.toRoomObject())
    }


    fun deleteAllAndroidVersion() {
        mAndroidVersionDao.deleteAll()
    }
}

private fun ObjectDataSample.toRoomObject(): LocalDataSourceSample {
    return LocalDataSourceSample(
        name = name,
        price = price,
        image = image
    )
}

private fun List<LocalDataSourceSample>.toObjectDataSample(): List<ObjectDataSample> {
    return map { eachItem ->
        ObjectDataSample(
            name = eachItem.name,
            price = eachItem.price,
            image = eachItem.image
        )
    }
}
