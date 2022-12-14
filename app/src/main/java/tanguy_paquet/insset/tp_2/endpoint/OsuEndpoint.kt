package tanguy_paquet.insset.tp_2.endpoint

import tanguy_paquet.insset.tp_2.model.OsuProfile
import retrofit2.http.*

interface OsuEndpoint {
    @GET("get_user?k=fa8c7e43e6cf5e6ba744e682bf2330751f484f5b&u={user_id}")
    suspend fun getOsuProfileByUserId(@Query("user_id") user_id:Int) : OsuProfile

    @GET("get_user?k=fa8c7e43e6cf5e6ba744e682bf2330751f484f5b&u={username}")
    suspend fun getOsuProfileByUsername(@Query("username") username:String) : OsuProfile
}