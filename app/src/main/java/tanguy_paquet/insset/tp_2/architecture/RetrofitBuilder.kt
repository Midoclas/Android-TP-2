package tanguy_paquet.insset.tp_2.architecture

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import tanguy_paquet.insset.tp_2.endpoint.OsuEndpoint

object RetrofitBuilder {
    private const val BASE_URL:String = "https://osu.ppy.sh/api/"
    private val gson : Gson by lazy {
        GsonBuilder().setLenient().create()
    }

    private val httpClient : OkHttpClient by lazy {
        OkHttpClient.Builder().build()
    }

    private val retrofit : Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    fun call() : OsuEndpoint = retrofit.create(OsuEndpoint::class.java)
}