package tanguy_paquet.insset.tp_2.endpoint

import retrofit2.Response
import retrofit2.http.*
import tanguy_paquet.insset.tp_2.model.OsuBeatmapsetidRetrofit
import tanguy_paquet.insset.tp_2.model.OsuBestRetrofit
import tanguy_paquet.insset.tp_2.model.OsuProfileRetrofit

interface OsuEndpoint {
    @GET("get_user?k=fa8c7e43e6cf5e6ba744e682bf2330751f484f5b")
    suspend fun getOsuProfile(@Query("u") user_id: String): ArrayList<OsuProfileRetrofit>

    @GET("get_user_best?k=fa8c7e43e6cf5e6ba744e682bf2330751f484f5b")
    suspend fun getOsuBest(@Query("u") user_id: String): ArrayList<OsuBestRetrofit>

    @GET("get_beatmaps?k=fa8c7e43e6cf5e6ba744e682bf2330751f484f5b")
    suspend fun getBeatmapsetid(@Query("b") beatmap_id: String): ArrayList<OsuBeatmapsetidRetrofit>
}