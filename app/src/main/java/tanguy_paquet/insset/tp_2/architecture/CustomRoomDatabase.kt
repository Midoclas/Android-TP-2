package tanguy_paquet.insset.tp_2.architecture

import androidx.room.Database
import androidx.room.RoomDatabase
import tanguy_paquet.insset.tp_2.dao.AndroidPriceDao
import tanguy_paquet.insset.tp_2.model.LocalDataSourceSample


@Database(
    entities = [
        LocalDataSourceSample::class
    ],
    version = 1,
    exportSchema = false
)
abstract class CustomRoomDatabase : RoomDatabase() {
    abstract fun mAndroidPriceDao(): AndroidPriceDao
}

