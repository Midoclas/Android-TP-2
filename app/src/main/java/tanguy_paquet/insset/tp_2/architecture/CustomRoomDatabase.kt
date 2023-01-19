package tanguy_paquet.insset.tp_2.architecture

import androidx.room.Database
import androidx.room.RoomDatabase
import tanguy_paquet.insset.tp_2.osu.data.bestMaps.local.BestMapsDao
import tanguy_paquet.insset.tp_2.osu.data.bestMaps.model.BestMapsRoom
import tanguy_paquet.insset.tp_2.osu.data.profile.local.ProfileDao
import tanguy_paquet.insset.tp_2.osu.data.profile.model.ProfileRoom


@Database(
    entities = [
        ProfileRoom::class,
        BestMapsRoom::class
    ],
    version = 7,
    exportSchema = false
)
abstract class CustomRoomDatabase : RoomDatabase() {
    abstract fun mProfileDao(): ProfileDao
    abstract fun mBestMapsDao(): BestMapsDao
}

