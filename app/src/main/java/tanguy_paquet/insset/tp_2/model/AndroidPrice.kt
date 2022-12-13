package tanguy_paquet.insset.tp_2.model
sealed class MyObjectForRecyclerView(label : String)

data class ObjectDataHeaderSample(
    val header: String
) : MyObjectForRecyclerView(label = header)

data class ObjectDataSample(
    val phoneName: String,
    val price: Int,
) : MyObjectForRecyclerView(label = phoneName)