package tanguy_paquet.insset.tp_2.architecture

import androidx.room.Database
import androidx.room.RoomDatabase
import tanguy_paquet.insset.tp_2.dao.OsuDao
import tanguy_paquet.insset.tp_2.model.OsuProfile


@Database(
    entities = [
        OsuProfile::class
    ],
    version = 1,
    exportSchema = false
)
abstract class CustomRoomDatabase : RoomDatabase() {
    abstract fun mOsuDao(): OsuDao
}

