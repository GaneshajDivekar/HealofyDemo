package healofy.demo.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import healofy.demo.databaseclass.SongsDB
import healofy.demo.model.JsonResponse
import healofy.demo.repository.MainRepository

class MainViewModel  @ViewModelInject constructor(private val mainRepository: MainRepository) : ViewModel() {

    fun putSongsData(): MutableLiveData<JsonResponse> {
        return mainRepository.putResponse()
    }

    fun insertPost(songsDB: SongsDB) {
        mainRepository.insertData(songsDB)
    }

    fun getSongsInfoo(): LiveData<List<SongsDB>> {
        return mainRepository.getPostsDataa()
    }

}