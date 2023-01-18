package tanguy_paquet.insset.tp_2.osu.data.bestMaps.remote

import retrofit2.http.GET
import retrofit2.http.Query
import tanguy_paquet.insset.tp_2.osu.data.bestMaps.model.BeatmapsetidRetrofit
import tanguy_paquet.insset.tp_2.osu.data.bestMaps.model.BestMapsRetrofit

interface BestMapsEndpoint {
    @GET("get_user_best?k=fa8c7e43e6cf5e6ba744e682bf2330751f484f5b")
    suspend fun getBestMaps(@Query("u") user_id: String): ArrayList<BestMapsRetrofit>

    @GET("get_beatmaps?k=fa8c7e43e6cf5e6ba744e682bf2330751f484f5b")
    suspend fun getBeatmapsetid(@Query("b") beatmap_id: String): ArrayList<BeatmapsetidRetrofit>
}