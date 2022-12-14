package tanguy_paquet.insset.tp_2.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

sealed class MyObjectForRecyclerView(label: String)

data class ObjectDataHeaderSample(
    val header: String
) : MyObjectForRecyclerView(label = header)


data class ObjectDataSample(
    val name: String,
    val price: Int,
    val image: String
) : MyObjectForRecyclerView(label = name)

@Entity(tableName = "android_price_object_table")
data class LocalDataSourceSample(
    @ColumnInfo(name = "name")
    val name: String,


    @ColumnInfo(name = "code")
    val price: Int,


    @ColumnInfo(name = "image")
    val image: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}
