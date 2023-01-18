package tanguy_paquet.insset.tp_2.osu.data.profile.remote

import retrofit2.http.GET
import retrofit2.http.Query
import tanguy_paquet.insset.tp_2.osu.data.profile.model.ProfileRetrofit

interface ProfileEndpoint {
    @GET("get_user?k=fa8c7e43e6cf5e6ba744e682bf2330751f484f5b")
    suspend fun getProfile(@Query("u") user_id: String): ArrayList<ProfileRetrofit>
}