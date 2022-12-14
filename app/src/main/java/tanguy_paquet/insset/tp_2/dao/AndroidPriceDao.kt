package tanguy_paquet.insset.tp_2.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import tanguy_paquet.insset.tp_2.model.LocalDataSourceSample

@Dao
interface AndroidPriceDao {


    @Query("SELECT * FROM android_price_object_table ORDER BY name ASC")
    fun selectAll(): LiveData<List<LocalDataSourceSample>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(androidVersion: LocalDataSourceSample)


    @Query("DELETE FROM android_price_object_table")
    fun deleteAll()
}
