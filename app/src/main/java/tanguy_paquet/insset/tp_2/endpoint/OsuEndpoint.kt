package tanguy_paquet.insset.tp_2.endpoint

import retrofit2.http.*
import tanguy_paquet.insset.tp_2.model.OsuProfileRetrofit

interface OsuEndpoint {
    @GET("get_user?k=fa8c7e43e6cf5e6ba744e682bf2330751f484f5b")
    suspend fun getOsuProfileByUserId(@Query("u") user_id: String): ArrayList<OsuProfileRetrofit>

    @GET("get_user?k=fa8c7e43e6cf5e6ba744e682bf2330751f484f5b")
    suspend fun getOsuProfileByUsername(@Query("u") username: String): ArrayList<OsuProfileRetrofit>
}