package tanguy_paquet.insset.tp_2.architecture

import android.app.Application
import androidx.room.Room

class OsuApplication:Application() {
    companion object {
        lateinit var instance: OsuApplication
    }


    val mApplicationDatabase:CustomRoomDatabase by lazy {
        Room.databaseBuilder(
            applicationContext,
            CustomRoomDatabase::class.java,
            "ProfileBase"
        ).fallbackToDestructiveMigration().build()
    }


    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}