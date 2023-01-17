package tanguy_paquet.insset.tp_2.architecture

import androidx.room.Database
import androidx.room.RoomDatabase
import tanguy_paquet.insset.tp_2.dao.OsuProfileDao
import tanguy_paquet.insset.tp_2.dao.OsuBestDao
import tanguy_paquet.insset.tp_2.model.OsuBest
import tanguy_paquet.insset.tp_2.model.OsuProfile


@Database(
    entities = [
        OsuProfile::class,
        OsuBest::class
    ],
    version = 3,
    exportSchema = false
)
abstract class CustomRoomDatabase : RoomDatabase() {
    abstract fun mOsuProfileDao(): OsuProfileDao
    abstract fun mOsuBestDao(): OsuBestDao
}

