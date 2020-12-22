package healofy.demo.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import healofy.demo.databaseclass.SongsDB
import healofy.demo.databaseclass.SongsDao
import healofy.demo.model.JsonResponse
import healofy.demo.network.APIService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val apiHelper: APIService,
    private val songsDao: SongsDao
) {

    var jsonResponseLiveData = MutableLiveData<JsonResponse>()

    fun putResponse(): MutableLiveData<JsonResponse> {
        apiHelper.getSongResponse()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).subscribe(
                { postResult ->
                    jsonResponseLiveData.postValue(postResult)
                },
                { error ->
                    jsonResponseLiveData.postValue(null)
                }
            )
        return jsonResponseLiveData
    }

    fun insertData(songsDB: SongsDB) {
        songsDao.insertData(songsDB)
    }
    fun getPostsDataa(): LiveData<List<SongsDB>> {
        return songsDao.getSongs()
    }


}