package tanguy_paquet.insset.tp_2.architecture

import android.app.Application
import androidx.room.Room
import tanguy_paquet.insset.tp_2.architecture.CustomRoomDatabase

class DefineDatabase:Application() {
    companion object {
        lateinit var instance: DefineDatabase
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