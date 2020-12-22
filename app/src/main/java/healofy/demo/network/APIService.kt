package healofy.demo.network

import healofy.demo.model.JsonResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path


interface APIService {
    @GET("fb01393e-9ecb-474a-98ad-5349bbaaa629")
    fun getSongResponse(): Observable<JsonResponse>
    companion object {
        const val Base_Url = "https://run.mocky.io/v3/"
    }
}
